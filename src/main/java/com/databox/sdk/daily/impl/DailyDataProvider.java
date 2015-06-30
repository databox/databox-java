package com.databox.sdk.daily.impl;

import java.util.Collection;
import java.util.Date;
import java.util.TreeSet;

import com.databox.sdk.DataProvider;
import com.databox.sdk.kpi.KPI;
import com.databox.sdk.kpi.KeyDateKPIComparator;

/**
 * DataProvider that holds daily KPI values. All dates are normalized to yyyy-MM-ddT00:00:00 time.
 * 
 * @author Uros Majeric
 * 
 */
public class DailyDataProvider implements DataProvider {
	protected TreeSet<KPI> data = new TreeSet<KPI>(new KeyDateKPIComparator());

	@Override
	public Collection<KPI> getKPIs() {
		return data;
	}

	/**
	 * Method searches for already existing KPI (for the provided date) in the list. If KPI is found then only value is incremented, otherwise a new KPI is
	 * added.
	 * 
	 * @param key
	 *            KPI key for which we are adding a value
	 * @param date
	 *            Date (that will be normalized) for which we are adding the KPI
	 * @param value
	 *            Value that will be appended to the existing KPI or KPI with this value will be created
	 */
	public KPI addKPI(String key, Date date, Double value) {
		KPI kpi = new KPI.Builder().setKey(key).setDate(date).setValue(value).normalized().build();
		if (data.contains(kpi)) {
			KPI found = data.tailSet(kpi).first();
			found.incrementValue(value);
		} else {
			data.add(kpi);
		}
		return kpi;
	}

	/**
	 * Method searches for already existing KPI (for the provided date) in the list. If KPI is found then only value is incremented, otherwise a new KPI is
	 * added.
	 * 
	 * @param key
	 *            KPI key for which we are incrementing a value
	 * @param date
	 *            Date (that will be normalized) for which we are adding the KPI
	 */
	public void incrementKPIsValue(String key, Date date) {
		addKPI(key, date, 1D);
	}

}