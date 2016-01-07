package com.databox.sdk;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Uros Majeric
 *
 */
public class DataboxTest extends TestCase {
	private static final Logger logger = LoggerFactory.getLogger(DataboxTest.class);

	private static final String TOKEN = "my_api_key";

	public void testPush() throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		Databox notification = new Databox(TOKEN);
		try {
			notification.push("kitchen_light", 341d, sdf.parse("2015-12-25 00:00:00"));
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
		}
	}

	public void testPushArray() throws IOException {
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
