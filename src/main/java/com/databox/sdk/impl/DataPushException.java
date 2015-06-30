package com.databox.sdk.impl;

/**
 * 
 * @author Uros Majeric
 * 
 */
public class DataPushException extends Exception {
	private static final long serialVersionUID = 1L;

	public DataPushException(Throwable t) {
		super(t);
	}

	public DataPushException(String cause) {
		super(cause);
	}

}
