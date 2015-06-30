package com.databox.sdk;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Default implementation of DataSource interface.
 * 
 * @author Uros Majeric
 * 
 */
public class DefaultDataSource implements DataSource {
	private List<DataProvider> _dataProviders = new ArrayList<DataProvider>();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DataProvider> getDataProviders() {
		return _dataProviders;
	}

	/**
	 * Method adds a dataProvider to the custom connection.
	 * 
	 * @param dataProvider
	 *            data provider that will be added to the connection.
	 */
	public void addDataProvider(DataProvider dataProvider) {
		_dataProviders.add(dataProvider);
	}
}
