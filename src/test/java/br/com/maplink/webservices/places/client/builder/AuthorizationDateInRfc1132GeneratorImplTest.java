package br.com.maplink.webservices.places.client.builder;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import br.com.maplink.webservices.places.client.builder.AuthorizationRfc1132DateGeneratorImpl;
import br.com.maplink.webservices.places.client.converter.DateConverter;
import br.com.maplink.webservices.places.client.helper.Clock;

public class AuthorizationDateInRfc1132GeneratorImplTest {
	
	private static final GregorianCalendar DATE_RETRIEVED = new GregorianCalendar();
	private static final String DATE_CONVERTED = "date-converted";
	private DateConverter mockedDateConverter;
	private Clock mockedClock;
	private AuthorizationRfc1132DateGeneratorImpl generator;

	@Before
	public void setUp() {
		mockedClock = mock(Clock.class);
		mockedDateConverter = mock(DateConverter.class);
		
		generator = new AuthorizationRfc1132DateGeneratorImpl(mockedClock, mockedDateConverter);
	}
	
	@Test
	public void shouldGenerateAuthorizationRfc1132Date() {
		givenCurrentDateWasRetrieved()
			.andDateCanBeConverted();
		
		assertThat(generator.build())
			.isEqualTo(DATE_CONVERTED);
	}
	
	@Test
	public void shouldRetrieveCurrentDateWhenGeneratinAuthorizationRfc1132Date() {
		givenCurrentDateWasRetrieved()
			.andDateCanBeConverted();
		
		generator.build();
		
		verify(mockedClock, times(1)).nowForCachingPurpose();
	}
	
	@Test
	public void shouldConvertToRfc1132WhenGeneratingAuthorizationRfc1132Date() {
		givenCurrentDateWasRetrieved()
			.andDateCanBeConverted();
		
		generator.build();

		verify(mockedDateConverter, times(1)).toRfc1132(DATE_RETRIEVED);
	}

	private void andDateCanBeConverted() {
		when(mockedDateConverter.toRfc1132(isA(GregorianCalendar.class)))
			.thenReturn(DATE_CONVERTED);
	}

	private AuthorizationDateInRfc1132GeneratorImplTest givenCurrentDateWasRetrieved() {
		when(mockedClock.nowForCachingPurpose())
			.thenReturn(DATE_RETRIEVED);
		
		return this;
	}
}
