package com.databox.sdk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.databox.sdk.kpi.KPI;

/**
 * Default implementation of DataProvider interface.
 * 
 * @author Uros Majeric
 * 
 */
public class DefaultDataProvider implements DataProvider {
	protected List<KPI> data = new ArrayList<KPI>();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<KPI> getKPIs() {
		return data;
	}

	/**
	 * Method adds a KPI to the data provider.
	 * 
	 * @param kpi
	 *            KPI that will be added to the data provider
	 */
	public void addKPI(KPI kpi) {
		data.add(kpi);
	}

	/**
	 * Method adds a list of KPIs to the data provider.
	 * 
	 * @param kpis
	 *            KPIs that will be added to the data provider
	 */
	public void addKPIs(List<KPI> kpis) {
		data.addAll(kpis);
	}
}
