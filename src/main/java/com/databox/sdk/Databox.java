package com.databox.sdk;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Uros Majeric
 */
public class Databox {
	static final Logger logger = LoggerFactory.getLogger(Databox.class);
	private static final String DEFAULT_HOST = "https://push2new.databox.com";

	private final String _token;
	private String _host;

	{
		_host = DEFAULT_HOST;
	}

	public Databox(String token) {
		if (token == null || token.isEmpty()) {
			throw new RuntimeException("Databox token cannot be empty!");
		}
		_token = token;
	}

	public void push(String key, Double value) {
		push(key, value, null, null);
	}

	public void push(String key, Double value, Date date) {
		push(key, value, date, null);
	}

	public void push(String key, Double value, Map<String, Object> attributes) {
		push(key, value, null, attributes);
	}

	public void push(String key, Double value, Date date, Map<String, Object> attributes) {
		if (key == null || value == null) {
			logger.error("Key and value must not be null ({}, {})", key, value);
			return;
		}

		final KPI kpi = new KPI().setKey(key).setValue(value).setDate(date);
		if (attributes != null) {
			kpi.addAttributes(attributes);
		}
		push(Arrays.asList(kpi));
	}

	public boolean push(List<KPI> kpis) {
		if (kpis != null && !kpis.isEmpty()) {
			String rawData = "{\"data\": " + kpis.toString() + "}";
			return push(rawData);
		}
		return false;
	}

	private boolean push(String rawData) {
		HttpURLConnection conn = null;
		OutputStream os = null;
		try {
			URL url = new URL(_host);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("User-Agent", "java-sdk");

			String encodedBytes = base64Encode((_token + ":").getBytes("UTF-8"));
			String authorization = "Basic " + encodedBytes;
			conn.setRequestProperty("Authorization", authorization);

			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(5000);

			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.write(rawData.getBytes("UTF-8"));
			wr.flush();
			wr.close();

			InputStream inputStream;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() < 300) {
				inputStream = conn.getInputStream();
			} else {
				inputStream = conn.getErrorStream();
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

			StringBuffer input = new StringBuffer();
			String in;
			while ((in = br.readLine()) != null) {
				input.append(in);
			}
			br.close();
			logger.info(input.toString() + ": " + rawData);
			return true;
		} catch (Exception e) {
			logger.error("Not send: " + rawData);
			logger.error(e.getLocalizedMessage(), e);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					logger.error(e.getLocalizedMessage(), e);
				}
			}
		}
		return false;
	}

	public void setHost(String host) {
		if (host == null || host.isEmpty()) {
			throw new RuntimeException("Databox 'host' cannot be empty!");
		}
		if (!host.startsWith("http")) {
			host = "http://" + host;
		}
		_host = host;
	}

	private String base64Encode(byte[] data) {
		char[] tbl = {
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
				'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

		StringBuilder buffer = new StringBuilder();
		int pad = 0;
		for (int i = 0; i < data.length; i += 3) {

			int b = ((data[i] & 0xFF) << 16) & 0xFFFFFF;
			if (i + 1 < data.length) {
				b |= (data[i + 1] & 0xFF) << 8;
			} else {
				pad++;
			}
			if (i + 2 < data.length) {
				b |= (data[i + 2] & 0xFF);
			} else {
				pad++;
			}

			for (int j = 0; j < 4 - pad; j++) {
				int c = (b & 0xFC0000) >> 18;
				buffer.append(tbl[c]);
				b <<= 6;
			}
		}
		for (int j = 0; j < pad; j++) {
			buffer.append("=");
		}

		return buffer.toString();
	}

	public static class KPI {
		public static final TimeZone DEFAULT_TIME_ZONE = TimeZone.getTimeZone("UTC");
		private static SimpleDateFormat SDF;

		private String key;
		private Object value;
		private Date date;
		private Map<String, Object> attributes = new HashMap<String, Object>();

		static {
			SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			SDF.setTimeZone(DEFAULT_TIME_ZONE);
		}

		public KPI() {
		}

		public String getKey() {
			return key;
		}

		public KPI setKey(String key) {
			this.key = key;
			return this;
		}

		public Object getValue() {
			return value;
		}

		public KPI setValue(Object value) {
			this.value = value;
			return this;
		}

		public Date getDate() {
			return date;
		}

		public KPI setDate(Date date) {
			this.date = date;
			return this;
		}

		public KPI addAttribute(String key, Object value) {
			attributes.put(key, value);
			return this;
		}

		public KPI addAttributes(Map<String, Object> attributes) {
			if (attributes != null) {
				attributes.putAll(attributes);
			}
			return this;
		}

		public void removeAttribute(String key) {
			if (attributes.containsKey(key)) {
				attributes.remove(key);
			}
		}

		public void clearAttributes() {
			attributes.clear();
		}

		public Map<String, Object> getAttributes() {
			return attributes;
		}

		@Override
		public String toString() {
			String json = " { \"$" + key + "\": " + value;
			if (date != null) {
				json += ", \"date\": \"" + SDF.format(date) + "\"";
			}
			for (Map.Entry<String, Object> atribute : attributes.entrySet()) {
				json += ", \"" + atribute.getKey() + "\": \"" + atribute.getValue() + "\"";
			}
			json += "}";
			return json;
		}
	}
}
