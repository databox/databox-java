package com.databox.sdk.kpi;

import java.util.Comparator;

/**
 * Comparator that compares two KPIs on their keys and date only. Value is not taken into the account in this comparator.
 * 
 * @author Uros Majeric
 * 
 */
public class KeyDateKPIComparator implements Comparator<KPI> {

	@Override
	public int compare(KPI kpi1, KPI kpi2) {
		if (kpi1 == kpi2) {
			return 0;
		}
		if (kpi1 == null) {
			if (kpi2 == null) {
				return 0;
			}
			return -1;
		}
		if (kpi2 == null) {
			return 1;
		}

		String key1 = kpi1.getKey();
		String key2 = kpi2.getKey();
		if (key1 == null) {
			if (key2 == null) {
				return 0;
			}
			return -1;
		}
		if (key2 == null) {
			return 1;
		}

		int compared = key1.compareTo(key2);
		if (compared != 0) {
			return compared;
		}

		String date1 = kpi1.getDate();
		String date2 = kpi2.getDate();
		if (date1 == null) {
			if (date2 == null) {
				return 0;
			}
			return -1;
		}
		if (date2 == null) {
			return 1;
		}

		return date1.compareTo(date2) * 479001599;
	}

}
