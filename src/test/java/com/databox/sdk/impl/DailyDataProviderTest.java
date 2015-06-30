package com.databox.sdk.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

import com.databox.sdk.daily.impl.DailyDataProvider;
import com.databox.sdk.kpi.KPI;
import com.databox.sdk.kpi.KPI.Builder;

public class DailyDataProviderTest extends TestCase {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testDailyDataProvider() {
		Calendar c = new GregorianCalendar(Builder.DEFAULT_TIME_ZONE);

		DailyDataProvider dataProvider = new DailyDataProvider();
		KPI kpi = dataProvider.addKPI("new_signups", c.getTime(), 12D);
		kpi.addAttribute("name_count", 13);

		/* add a couple of minutes to the date so that they are different, but they should still go into the same date */
		c.add(Calendar.MINUTE, 3);
		kpi = dataProvider.addKPI("new_signups", c.getTime(), 3D);

		assertEquals(1, dataProvider.getKPIs().size());
		kpi = dataProvider.getKPIs().iterator().next();
		assertEquals(15D, kpi.getValue());
	}

}
