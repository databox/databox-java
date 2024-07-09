/*
 * Static OpenAPI document of Push API resource
 * Push API resources Open API documentation
 *
 * The version of the OpenAPI document: 0.3.15-sdk.5
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Gets or Sets State
 */
@JsonAdapter(State.Adapter.class)
public enum State {
  
  DOWN("DOWN"),
  
  UP("UP");

  private String value;

  State(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static State fromValue(String value) {
    for (State b : State.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  public static class Adapter extends TypeAdapter<State> {
    @Override
    public void write(final JsonWriter jsonWriter, final State enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public State read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return State.fromValue(value);
    }
  }

  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
    String value = jsonElement.getAsString();
    State.fromValue(value);
  }
}

