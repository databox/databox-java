package com.databox.sdk;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataboxTest extends TestCase {
  private static final Logger logger = LoggerFactory.getLogger(DataboxTest.class);

  public String getToken() {
    String envToken = System.getenv("DATABOX_PUSH_TOKEN");
    return envToken == null ? "my_api_key" : envToken;
  }

  public void testPush() throws IOException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    Databox notification = new Databox(getToken());

    try {
      notification.push("kitchen_light", 341d, sdf.parse("2015-12-25 00:00:00"));
    } catch (Exception e) {
      logger.error(e.getLocalizedMessage(), e);
    }
  }

  public void testLastPush() throws IOException {
    StringBuffer lastPush = new Databox(getToken()).lastPush();
    assert lastPush.toString().matches("(.*)kitchen_light(.*)");
  }

  public void testLastPushes() throws IOException {
    StringBuffer lastPushes = new Databox(getToken()).lastPushes(3);
    assert lastPushes.toString().matches("(.*)kitchen_light(.*)");
  }

}
