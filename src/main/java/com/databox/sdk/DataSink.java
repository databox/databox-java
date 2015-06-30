package com.databox.sdk;

import com.databox.sdk.impl.DataPushException;
import com.databox.sdk.impl.DataboxDataSource;

/**
 * 
 * Interface that serves as a sink for the data retrieved from different providers.
 * 
 * @author Uros Majeric
 * 
 */
public interface DataSink<T extends DataSource> {

	/**
	 * Push the data from all connections to the sink.
	 * 
	 * @return The response that was returned from Databox server wrapped in a ResponseWrapper.
	 * 
	 * @throws DataPushException
	 */
	ResponseWrapper push(T source) throws DataPushException;

	/**
	 * 
	 * Method returns the logs for the latest push for source.
	 * 
	 * @param connection
	 *            Connection for which we would like to get the log.
	 * @return String for the latest error.
	 * @throws Exception
	 */
	String getLogs(T source) throws Exception;

	/**
	 * 
	 * Method returns the logs for the latest push for source.
	 * 
	 * @param source
	 *            Source for which we would like to get the log.
	 * @param noOfItems
	 *            Number of logs to retrieve
	 * @return String for the latest error.
	 * 
	 * @throws Exception
	 */
	public String getLogs(T source, Integer noOfItems) throws Exception;

}
