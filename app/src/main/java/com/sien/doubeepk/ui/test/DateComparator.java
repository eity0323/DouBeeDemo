package com.sien.doubeepk.ui.test;

import java.util.Comparator;

public class DateComparator implements Comparator<DateText> {

	@Override
	public int compare(DateText lhs, DateText rhs) {
		return rhs.getDate().compareTo(lhs.getDate());
	}

}
