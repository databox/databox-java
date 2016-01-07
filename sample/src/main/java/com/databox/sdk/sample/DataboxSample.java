package com.databox.sdk.sample;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Uros Majeric
 *
 */
public class DataboxSample {
	private static final Logger logger = LoggerFactory.getLogger(DataboxSample.class);
	private static final String TOKEN = "my_api_key";

	public static void main(String[] args) throws Exception {
		final String TOKEN = "my_api_key";
		Databox notification = new Databox(TOKEN);
		try {
			List<Databox.KPI> kpis = new ArrayList<>();
			kpis.add(new Databox.KPI().setKey("my_first_key").setValue(1201.41));
			kpis.add(new Databox.KPI().setKey("my_second_key").setValue(8249));
			notification.push(kpis);
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
		}
	}
}
