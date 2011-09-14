package br.com.maplink.webservices.places.client.builder;

import br.com.maplink.webservices.places.client.converter.DateConverter;
import br.com.maplink.webservices.places.client.helper.Clock;

public class AuthorizationRfc1132DateGeneratorImpl implements AuthorizationRfc1132DateGenerator {
	
	private final Clock clock;
	private final DateConverter dateConverter;

	public AuthorizationRfc1132DateGeneratorImpl(Clock clock, DateConverter dateConverter){
		this.clock = clock;
		this.dateConverter = dateConverter;
		
	}
	
	@Override
	public String build(){
		return dateConverter.toRfc1132(clock.nowForCachingPurpose());
	}
}
