package com.databox.sdk;


import java.io.IOException;
import java.text.SimpleDateFormat;
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

	private static final String TOKEN = "mj2dx0y7xk0g4wwos8o884cc0gs0woow";

	public void testTrigger() throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		Databox notification = new Databox(TOKEN);
		try {
			notification.push("kitchen_light", 341d, sdf.parse("2015-12-25 00:00:00"));
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage(), e);
		}
	}

}
