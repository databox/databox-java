package com.databox.sdk.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.databox.Environment;

/**
 * 
 * @author Uros Majeric
 * 
 */
class DataboxHttpClient {
	private static final Logger logger = LoggerFactory.getLogger(DataboxHttpClient.class);

	public static final Integer CONNECTION_TIMEOUT_MS = 10000;
	private static final String POST_CONTENT_TYPE = "application/json";

	private final URI _url;
	private final String _username;
	private final String _password;

	/**
	 * Last response returned form Service
	 */
	private static final ThreadLocal<String> _lastStatus = new ThreadLocal<String>();

	public DataboxHttpClient(URI url, String username) {
		this(url, username, null);
	}

	public DataboxHttpClient(URI url, String username, String password) {
		_url = url;
		_username = username;
		_password = password;
	}

	public String postData(String data) throws AuthenticationException, ClientProtocolException, IOException, KeyManagementException, NoSuchAlgorithmException,
			KeyStoreException {
		logger.debug("postData: " + data);
		HttpRequestBase httpRequest = prepareRequest(_url, data);
		String response = invokeRequest(httpRequest);
		return response;
	}

	public String get() throws AuthenticationException, ClientProtocolException, IOException, KeyManagementException, NoSuchAlgorithmException,
			KeyStoreException {
		HttpRequestBase httpRequest = new HttpGet(_url);
		addAddHeaders(httpRequest);

		/* Invoke the request */
		String response = invokeRequest(httpRequest);
		return response;
	}

	private String invokeRequest(HttpRequestBase httpRequest) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, IOException {
		HttpHost targetHost = new HttpHost(_url.getHost(), _url.getPort(), _url.getScheme());

		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(new AuthScope(targetHost.getHostName(), targetHost.getPort()), new UsernamePasswordCredentials(_username, _password));

		HttpClientBuilder clientBuilder = HttpClients.custom().setDefaultCredentialsProvider(credsProvider);
		if ("https".equalsIgnoreCase(targetHost.getSchemeName())) {
			addSSLSupport(clientBuilder);
		}

		CloseableHttpClient httpclient = clientBuilder.build();
		try {
			AuthCache authCache = new BasicAuthCache();
			// Generate BASIC scheme object and add it to the local auth cache
			BasicScheme basicAuth = new BasicScheme();
			authCache.put(targetHost, basicAuth);

			// Add AuthCache to the execution context
			HttpClientContext localContext = HttpClientContext.create();
			localContext.setAuthCache(authCache);

			CloseableHttpResponse response = null;
			try {
				response = httpclient.execute(targetHost, httpRequest, localContext);

				int responseStatus = response.getStatusLine().getStatusCode();
				_lastStatus.set(response.getStatusLine().toString());
				if (responseStatus >= 200 && responseStatus < 300) {
					HttpEntity res_entity = response.getEntity();
					return EntityUtils.toString(res_entity, "UTF-8");
				}
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage(), e);
			} finally {
				if (response != null) {
					response.close();
				}
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
		} finally {
			httpclient.close();
		}
		return null;
	}

	protected void addSSLSupport(HttpClientBuilder clientBuilder) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {
		SSLContext sslcontext = SSLContexts.custom() //
				.loadTrustMaterial(null, new TrustSelfSignedStrategy()) //
				.build();

		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		clientBuilder.setSSLSocketFactory(sslsf);
	}

	protected HttpRequestBase prepareRequest(URI url, String data) throws UnsupportedEncodingException {
		HttpPost post = new HttpPost(url);
		addAddHeaders(post);

		/* convert the request object to a string that will be sent in the post */
		StringEntity entity = new StringEntity(data, "UTF-8");
		entity.setContentType(POST_CONTENT_TYPE);
		post.setEntity(entity);

		return post;
	}

	private void addAddHeaders(HttpRequestBase post) {
		post.setHeader("Accept", POST_CONTENT_TYPE);
		post.addHeader("User-Agent", Environment.getUserAgent());
	}

	public String getLastStatus() {
		return _lastStatus.get();
	}
}
