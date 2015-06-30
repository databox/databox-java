package com.databox.sdk.impl;

import com.databox.sdk.DefaultDataSource;

/**
 * @author Uros Majeric
 *
 */
public class DataboxDataSource extends DefaultDataSource {
	private final String _accessToken;

	/**
	 *
	 * @param accessToken
	 *            Access Token for Databox connection (required).
	 */
	public DataboxDataSource(String accessToken) {
		_accessToken = accessToken;
	}

	/**
	 *
	 * @return Unique URL ('Push URL') for Databox connection.
	 */
	public String getAccessToken() {
		return _accessToken;
	}
}
