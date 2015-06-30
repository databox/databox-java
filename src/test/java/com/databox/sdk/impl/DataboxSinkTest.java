package com.databox.sdk.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.databox.sdk.DataSink;
import com.databox.sdk.DefaultDataProvider;
import com.databox.sdk.ResponseWrapper;
import com.databox.sdk.kpi.KPI;
import com.databox.sdk.kpi.KPI.Builder;

public class DataboxSinkTest extends TestCase {
	private static final Logger logger = LoggerFactory.getLogger(DataboxSinkTest.class);

	private DataSink<DataboxDataSource> _sink;

	private DataboxDataSource _dataSource;

	@Override
	protected void setUp() throws Exception {
		_sink = new DataboxSink();
		String accessToken = System.getProperty("access-token");
		if (accessToken != null && !accessToken.isEmpty()) {
			_dataSource = new DataboxDataSource(accessToken);
		}
	}

	public void testDatabox() {
		if (_dataSource != null) {
			Calendar date = new GregorianCalendar(Builder.DEFAULT_TIME_ZONE);
			Calendar yesterday = ((Calendar) date.clone());
			yesterday.roll(Calendar.DAY_OF_YEAR, -1);

			DefaultDataProvider dataProvider = new DefaultDataProvider();
			dataProvider.addKPI(new KPI.Builder().setKey("new_signups").setValue(125D).withAttribute("no_of_items", 12).build());
			dataProvider.addKPI(new KPI.Builder().setKey("new_signups").setValue(205D).setDate(yesterday.getTime()).build());
			_dataSource.addDataProvider(dataProvider);

			try {
				ResponseWrapper response = _sink.push(_dataSource);
				if (!response.isSucceeded()) {
					logger.error(_sink.getLogs(_dataSource));
				}
				logger.info("Response succceeded: {}, with message: '{}'", response.isSucceeded(), response.getMessage());
			} catch (DataPushException e) {
				logger.error(e.getLocalizedMessage(), e);
			} catch (Exception e) {
				logger.error(e.getLocalizedMessage(), e);
			}
		}
	}
}
