package br.com.maplink.webservices.places.client.entity;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ApiRequestTest {

	@Test
	public void shouldHavePathAndQuery() {
		ApiRequest request = new ApiRequest();
		request.setPathAndQuery("path-and-query");
		
		assertThat(request.hasPathAndQuery())
			.isTrue();
	}
	
	@Test
	public void shouldNotHavePathAndQueryIfItIsEmpty() {
		ApiRequest request = new ApiRequest();
		request.setPathAndQuery("");
		
		assertThat(request.hasPathAndQuery())
			.isFalse();
	}
	
	@Test
	public void shouldNotHavePathAndQueryIfItIsNull() {
		ApiRequest request = new ApiRequest();
		
		assertThat(request.hasPathAndQuery())
			.isFalse();
	}
}
