package br.com.maplink.webservices.places.client.helper;

import static org.fest.assertions.Assertions.assertThat;

import java.util.GregorianCalendar;

import org.junit.Test;

import br.com.maplink.webservices.places.client.helper.ClockImpl;

public class ClockImplTest {

	@Test
	public void shouldRetrieveCurrentDateForCachingPurpose() {
		GregorianCalendar now = new GregorianCalendar();
		
		ClockImpl clock = new ClockImpl();

		GregorianCalendar dateRetrieved = clock.nowForCachingPurpose();
		
		assertThat(dateRetrieved.get(GregorianCalendar.YEAR))
			.isEqualTo(now.get(GregorianCalendar.YEAR));

		assertThat(dateRetrieved.get(GregorianCalendar.MONTH))
			.isEqualTo(now.get(GregorianCalendar.MONTH));
		
		assertThat(dateRetrieved.get(GregorianCalendar.DAY_OF_MONTH))
			.isEqualTo(now.get(GregorianCalendar.DAY_OF_MONTH));
		
		assertThat(dateRetrieved.get(GregorianCalendar.HOUR_OF_DAY))
			.isEqualTo(now.get(GregorianCalendar.HOUR_OF_DAY));
		
		assertThat(dateRetrieved.get(GregorianCalendar.MINUTE))
			.isEqualTo(1);
		
		assertThat(dateRetrieved.get(GregorianCalendar.SECOND))
			.isEqualTo(1);
	}
}
