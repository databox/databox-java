package com.databox.sdk;

/**
 * A wrapper of the response for pushing the data to the sink.
 * 
 * @author Uros Majeric
 * 
 */
public class ResponseWrapper {
	private boolean _succeeded = false;
	private String _message;

	/**
	 * 
	 * @return true if response has succeeded, false otherwise.
	 */
	public boolean isSucceeded() {
		return _succeeded;
	}

	public void setSucceeded(boolean succeeded) {
		_succeeded = succeeded;
	}

	/**
	 * 
	 * @return Text message of the response.
	 */
	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}
}
