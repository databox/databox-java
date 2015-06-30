package com.databox.sdk.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.databox.sdk.DataSink;
import com.databox.sdk.ResponseWrapper;
import com.databox.sdk.impl.DataboxDataSource;
import com.databox.sdk.impl.DataboxSink;

/**
 *
 * @author Uros Majeric
 *
 */
public class DataboxSample {
	private static final Logger logger = LoggerFactory.getLogger(DataboxSample.class);

	public static void main(String[] args) throws Exception {
		String spaceAccessToken = "hd32o1ga8sf7sad0fu9sdufs8440442kj2";

		DataSink<DataboxDataSource> sink = new DataboxSink();

		DataboxDataSource connection = new DataboxDataSource(spaceAccessToken);
		XSLDailyDataProvider xlsxDataProvider = new XSLDailyDataProvider("cycling.xlsx");
		connection.addDataProvider(xlsxDataProvider);

		// DefaultDataProvider dataProvider = new DefaultDataProvider();
		// Calendar c = new GregorianCalendar();
		// dataProvider.addKPI(new KPI.Builder().setKey("visits_this_month").setValue(234D).setDate(c.getTime()).build());
		// c.add(Calendar.DAY_OF_MONTH, -1);
		// dataProvider.addKPI(new KPI.Builder().setKey("visits_this_month").setValue(431D).build());
		// connection.addDataProvider(dataProvider);

		ResponseWrapper response = sink.push(connection);
		if (!response.isSucceeded()) {
			logger.error(sink.getLogs(connection));
		} else {
			logger.info(response.getMessage());
		}
	}
}
