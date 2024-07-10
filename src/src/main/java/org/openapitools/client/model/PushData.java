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
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.client.model.PushDataAttribute;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.databox.JSON;

/**
 * PushData
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-07-10T07:53:22.529213Z[Etc/UTC]", comments = "Generator version: 7.6.0")
public class PushData {
  public static final String SERIALIZED_NAME_ATTRIBUTES = "attributes";
  @SerializedName(SERIALIZED_NAME_ATTRIBUTES)
  private List<PushDataAttribute> attributes = new ArrayList<>();

  public static final String SERIALIZED_NAME_DATE = "date";
  @SerializedName(SERIALIZED_NAME_DATE)
  private String date;

  public static final String SERIALIZED_NAME_KEY = "key";
  @SerializedName(SERIALIZED_NAME_KEY)
  private String key;

  public static final String SERIALIZED_NAME_PERIOD_FROM = "periodFrom";
  @SerializedName(SERIALIZED_NAME_PERIOD_FROM)
  private String periodFrom;

  public static final String SERIALIZED_NAME_PERIOD_TO = "periodTo";
  @SerializedName(SERIALIZED_NAME_PERIOD_TO)
  private String periodTo;

  public static final String SERIALIZED_NAME_UNIT = "unit";
  @SerializedName(SERIALIZED_NAME_UNIT)
  private String unit;

  public static final String SERIALIZED_NAME_VALUE = "value";
  @SerializedName(SERIALIZED_NAME_VALUE)
  private Float value;

  public PushData() {
  }

  public PushData attributes(List<PushDataAttribute> attributes) {
    this.attributes = attributes;
    return this;
  }

  public PushData addAttributesItem(PushDataAttribute attributesItem) {
    if (this.attributes == null) {
      this.attributes = new ArrayList<>();
    }
    this.attributes.add(attributesItem);
    return this;
  }

   /**
   * Get attributes
   * @return attributes
  **/
  @javax.annotation.Nullable
  public List<PushDataAttribute> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<PushDataAttribute> attributes) {
    this.attributes = attributes;
  }


  public PushData date(String date) {
    this.date = date;
    return this;
  }

   /**
   * Get date
   * @return date
  **/
  @javax.annotation.Nullable
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }


  public PushData key(String key) {
    this.key = key;
    return this;
  }

   /**
   * Get key
   * @return key
  **/
  @javax.annotation.Nullable
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }


  public PushData periodFrom(String periodFrom) {
    this.periodFrom = periodFrom;
    return this;
  }

   /**
   * Get periodFrom
   * @return periodFrom
  **/
  @javax.annotation.Nullable
  public String getPeriodFrom() {
    return periodFrom;
  }

  public void setPeriodFrom(String periodFrom) {
    this.periodFrom = periodFrom;
  }


  public PushData periodTo(String periodTo) {
    this.periodTo = periodTo;
    return this;
  }

   /**
   * Get periodTo
   * @return periodTo
  **/
  @javax.annotation.Nullable
  public String getPeriodTo() {
    return periodTo;
  }

  public void setPeriodTo(String periodTo) {
    this.periodTo = periodTo;
  }


  public PushData unit(String unit) {
    this.unit = unit;
    return this;
  }

   /**
   * Get unit
   * @return unit
  **/
  @javax.annotation.Nullable
  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }


  public PushData value(Float value) {
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @javax.annotation.Nullable
  public Float getValue() {
    return value;
  }

  public void setValue(Float value) {
    this.value = value;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PushData pushData = (PushData) o;
    return Objects.equals(this.attributes, pushData.attributes) &&
        Objects.equals(this.date, pushData.date) &&
        Objects.equals(this.key, pushData.key) &&
        Objects.equals(this.periodFrom, pushData.periodFrom) &&
        Objects.equals(this.periodTo, pushData.periodTo) &&
        Objects.equals(this.unit, pushData.unit) &&
        Objects.equals(this.value, pushData.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributes, date, key, periodFrom, periodTo, unit, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PushData {\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    periodFrom: ").append(toIndentedString(periodFrom)).append("\n");
    sb.append("    periodTo: ").append(toIndentedString(periodTo)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("attributes");
    openapiFields.add("date");
    openapiFields.add("key");
    openapiFields.add("periodFrom");
    openapiFields.add("periodTo");
    openapiFields.add("unit");
    openapiFields.add("value");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to PushData
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!PushData.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in PushData is not found in the empty JSON string", PushData.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!PushData.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `PushData` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if (jsonObj.get("attributes") != null && !jsonObj.get("attributes").isJsonNull()) {
        JsonArray jsonArrayattributes = jsonObj.getAsJsonArray("attributes");
        if (jsonArrayattributes != null) {
          // ensure the json data is an array
          if (!jsonObj.get("attributes").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `attributes` to be an array in the JSON string but got `%s`", jsonObj.get("attributes").toString()));
          }

          // validate the optional field `attributes` (array)
          for (int i = 0; i < jsonArrayattributes.size(); i++) {
            PushDataAttribute.validateJsonElement(jsonArrayattributes.get(i));
          };
        }
      }
      if ((jsonObj.get("date") != null && !jsonObj.get("date").isJsonNull()) && !jsonObj.get("date").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `date` to be a primitive type in the JSON string but got `%s`", jsonObj.get("date").toString()));
      }
      if ((jsonObj.get("key") != null && !jsonObj.get("key").isJsonNull()) && !jsonObj.get("key").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `key` to be a primitive type in the JSON string but got `%s`", jsonObj.get("key").toString()));
      }
      if ((jsonObj.get("periodFrom") != null && !jsonObj.get("periodFrom").isJsonNull()) && !jsonObj.get("periodFrom").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `periodFrom` to be a primitive type in the JSON string but got `%s`", jsonObj.get("periodFrom").toString()));
      }
      if ((jsonObj.get("periodTo") != null && !jsonObj.get("periodTo").isJsonNull()) && !jsonObj.get("periodTo").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `periodTo` to be a primitive type in the JSON string but got `%s`", jsonObj.get("periodTo").toString()));
      }
      if ((jsonObj.get("unit") != null && !jsonObj.get("unit").isJsonNull()) && !jsonObj.get("unit").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `unit` to be a primitive type in the JSON string but got `%s`", jsonObj.get("unit").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!PushData.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'PushData' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<PushData> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(PushData.class));

       return (TypeAdapter<T>) new TypeAdapter<PushData>() {
           @Override
           public void write(JsonWriter out, PushData value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public PushData read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of PushData given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of PushData
  * @throws IOException if the JSON string is invalid with respect to PushData
  */
  public static PushData fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, PushData.class);
  }

 /**
  * Convert an instance of PushData to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}

