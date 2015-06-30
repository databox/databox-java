package com.databox.sdk.kpi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;

/**
 * 
 * KPI class that is send to the Databox server.<br />
 * Use KPI.Builder to create an instance of this class.
 * 
 * 
 * @author Uros Majeric
 * 
 */
public class KPI {
	private String key;
	private Object value;
	private String date;
	private Map<String, Object> attributes = new HashMap<String, Object>();

	/**
	 * Constructor is private by default. Use KPI builder to create new instance.
	 */
	private KPI() {

	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public void addAttribute(String key, Object value) {
		attributes.put(key, value);
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
	
	/**
	 * Increments the value for this KPI.
	 * 
	 * @param value
	 *            number with which the current value will be incremented
	 */
	public void incrementValue(Double value) {
		if (this.value == null) {
			this.value = 0D;
		}
		if (value != null && this.value instanceof Double) {
			this.value = ((Double) this.value) + value;
		}
	}

	@Override
	public String toString() {
		return KPI.class.getSimpleName() + "(" + key + ";" + date + "=" + value + "; " + attributes + ")";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KPI other = (KPI) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		return true;
	}



	/**
	 * Each KPI is created via this Builder class. It is used to simplify the creation of the KPIs, with different creation settings.
	 * 
	 * @author Uros Majeric
	 * 
	 */
	public static class Builder {
		public static final TimeZone DEFAULT_TIME_ZONE = TimeZone.getTimeZone("UTC");
		private static SimpleDateFormat SDF;

		private String _key;
		private Object _value;
		private Date _date;
		private Map<String, Object> _attributes = new HashMap<String, Object>();
		private boolean _normalized;

		static {
			SDF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			SDF.setTimeZone(DEFAULT_TIME_ZONE);
		}

		public Builder setKey(String key) {
			_key = key;
			return this;
		}

		public Builder setValue(Object value) {
			_value = value;
			return this;
		}

		public Builder setDate(Date date) {
			_date = date;
			return this;
		}
		
		public Builder withAttribute(String key, Object value) {
			_attributes.put(key, value);
			return this;
		}

		/**
		 * KPI created with this method call will have its date field normalized to zero hour at the day.
		 * 
		 * @return
		 */
		public Builder normalized() {
			_normalized = true;
			return this;
		}
		
		/**
		 * KPI created with this method call will have its date field normalized to zero hour at the day.
		 * 
		 * @return
		 */
		public Builder setNormalized(boolean normalized) {
			_normalized = normalized;
			return this;
		}

		public KPI build() {
			KPI kpi = new KPI();
			if (_key == null || _key.trim().isEmpty()) {
				throw new RuntimeException("Key is KPI's mandatory field!");
			}
			kpi.setKey(_key);
			kpi.setValue(_value);
			if (_date == null) {
				_date = new Date();
			}
			if (_normalized) {
				_date = normalizeDate(_date);
			}
			kpi.setDate(SDF.format(_date));
			
			for (Entry<String, Object> attribute : _attributes.entrySet()) {
				kpi.addAttribute(attribute.getKey(), attribute.getValue());
			}
			
			return kpi;
		}

		/**
		 * Method normalizes the date to the 00:00:00 time.
		 * 
		 * @return
		 */
		public static Date normalizeDate(Date date) {
			if (date == null) {
				return null;
			}
			Calendar cal = new GregorianCalendar(DEFAULT_TIME_ZONE);
			cal.setTime(date);

			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);

			return cal.getTime();
		}
	}

}
