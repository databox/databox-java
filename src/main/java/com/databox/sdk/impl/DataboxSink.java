package com.databox.sdk.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.databox.Environment;
import com.databox.sdk.DataProvider;
import com.databox.sdk.DataSink;
import com.databox.sdk.ResponseWrapper;
import com.databox.sdk.kpi.KPI;
import com.databox.sdk.kpi.KPIJsonSerializer;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Default implementation for DataSink. DataboxSink is a sink for the KPIs generated for custom connection created on Databox WEB app.
 *
 * @author Uros Majeric
 *
 */
public class DataboxSink implements DataSink<DataboxDataSource> {
	private static final Logger logger = LoggerFactory.getLogger(DataboxSink.class);
	private static final String LOGS_PATH = "/lastpushes";

	/**
	 * @param accessToken
	 *
	 */
	public DataboxSink() {
	}

	/**
	 * {@inheritDoc}
	 *
	 */
	@Override
	public ResponseWrapper push(DataboxDataSource source) throws DataPushException {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		DataboxRequestModel aggregated = new DataboxRequestModel();
		for (DataProvider dp : source.getDataProviders()) {
			aggregated.addKPIs(dp.getKPIs());
		}

		GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(KPI.class, new KPIJsonSerializer());
		String json = builder.create().toJson(aggregated);

		try {
			String databoxBaseURL = Environment.getDataboxBaseURL();
			URI url = URI.create(databoxBaseURL);

			DataboxHttpClient client = new DataboxHttpClient(url, source.getAccessToken());
			String response = client.postData(json);
			logger.debug("Response from Databox server was: {}", response);
			if (response != null) {
				parseResponse(response, responseWrapper);
			} else {
				responseWrapper.setSucceeded(false);
				if (client.getLastStatus() != null) {
					responseWrapper.setMessage(client.getLastStatus());
				} else {
					responseWrapper.setMessage("Response was empty and there is no last status message!");
				}
			}
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
			throw new DataPushException(e);
		}
		return responseWrapper;
	}

	@Override
	public String getLogs(DataboxDataSource source) throws Exception {
		return getLogs(source, null);
	}

	@Override
	public String getLogs(DataboxDataSource source, Integer noOfItems) throws Exception {
		String databoxBaseURL = Environment.getDataboxBaseURL();
		URI url = URI.create(databoxBaseURL + LOGS_PATH + (noOfItems != null ? "/" + noOfItems : ""));

		DataboxHttpClient client = new DataboxHttpClient(url, source.getAccessToken());
		String response = client.postData("");

		return response;
	}

	private boolean parseResponse(String response, ResponseWrapper responseWrapper) {
		JsonParser parser = new JsonParser();
		JsonElement parsed = parser.parse(response);
		if (parsed != null && parsed.isJsonObject()) {
			JsonElement jsonResponse = parsed.getAsJsonObject().get("status");
			if (jsonResponse != null && jsonResponse.isJsonPrimitive()) {
				boolean succeeded = "ok".equalsIgnoreCase(jsonResponse.getAsString());
				responseWrapper.setSucceeded(succeeded);
				return succeeded;
			}
		}
		return false;
	}

	private static final class DataboxRequestModel {
		protected List<KPI> data = new ArrayList<KPI>();

		public void addKPIs(Collection<KPI> kpis) {
			data.addAll(kpis);
		}
	}
}
