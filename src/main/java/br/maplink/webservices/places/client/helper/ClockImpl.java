package br.maplink.webservices.places.client.helper;

import java.util.GregorianCalendar;

public class ClockImpl implements Clock {

	@Override
	public GregorianCalendar nowForCachingPurpose() {
		GregorianCalendar now = new GregorianCalendar();
		
		return new GregorianCalendar(
				now.get(GregorianCalendar.YEAR),
				now.get(GregorianCalendar.MONTH),
				now.get(GregorianCalendar.DAY_OF_MONTH),
				now.get(GregorianCalendar.HOUR_OF_DAY),
				1,
				1);
	}
}
