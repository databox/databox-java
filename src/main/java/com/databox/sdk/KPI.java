package com.databox.sdk;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class KPI {
  public static final TimeZone DEFAULT_TIME_ZONE = TimeZone.getTimeZone("UTC");
  private static SimpleDateFormat SDF;

  private String key;
  private Object value;
  private Date date;
  private Map<String, Object> attributes = new HashMap<>();

  static {
    SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    SDF.setTimeZone(DEFAULT_TIME_ZONE);
  }

  public KPI() {
  }

  public String getKey() {
    return key;
  }

  public KPI setKey(String key) {
    this.key = key;
    return this;
  }

  public Object getValue() {
    return value;
  }

  public KPI setValue(Object value) {
    this.value = value;
    return this;
  }

  public Date getDate() {
    return date;
  }

  public KPI setDate(Date date) {
    this.date = date;
    return this;
  }

  public KPI addAttribute(String key, Object value) {
    attributes.put(key, value);
    return this;
  }

  public KPI addAttributes(Map<String, Object> attributes) {
    if (attributes != null) {
      attributes.putAll(attributes);
    }
    return this;
  }

  public void removeAttribute(String key) {
    if (attributes.containsKey(key)) {
      attributes.remove(key);
    }
  }

  public void clearAttributes() {
    attributes.clear();
  }

  public Map<String, Object> getAttributes() {
    return attributes;
  }

  @Override
  public String toString() {
    String json = " { \"$" + key + "\": " + value;
    if (date != null) {
      json += ", \"date\": \"" + SDF.format(date) + "\"";
    }
    for (Map.Entry<String, Object> atribute : attributes.entrySet()) {
      json += ", \"" + atribute.getKey() + "\": \"" + atribute.getValue() + "\"";
    }
    json += "}";
    return json;
  }
}
