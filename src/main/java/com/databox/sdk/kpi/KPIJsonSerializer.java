package com.databox.sdk.kpi;

import java.lang.reflect.Type;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * 
 * @author Uros Majeric
 *
 */
public final class KPIJsonSerializer implements JsonSerializer<KPI> {

	@Override
	public JsonElement serialize(KPI kpi, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject kpiJson = null;
		if (kpi.getKey() != null && kpi.getValue() != null) {
			kpiJson = new JsonObject();
			kpiJson.addProperty("$" + kpi.getKey(), kpi.getValue().toString());
			
			if (kpi.getDate() != null) {
				kpiJson.addProperty("date", kpi.getDate());
			}

			for (Entry<String, Object> attribure : kpi.getAttributes().entrySet()) {
				if (attribure.getKey() != null && attribure.getValue() != null) {
					kpiJson.addProperty(attribure.getKey(), attribure.getValue().toString());
				}
			}
		}
		return kpiJson;
	}
}