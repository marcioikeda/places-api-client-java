package br.com.maplink.webservices.places.client.builder;

import br.com.maplink.webservices.places.client.entity.ApiRequest;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ApiRequestBuilderImplTest {

	private ApiRequestBuilder builder;

	@Before
	public void setUp() {
		builder = new ApiRequestBuilderImpl();
	}
	
	@Test
	public void shouldCreateApiRequestWithHost() {
		assertThat(builder.withHost("host").build().getHost())
			.isEqualTo("host");
	}
	
	@Test
	public void shouldNotRetrieveTheSameInstanceWhenBuildingANewApiRequest() {
		ApiRequest firstApiRequestBuilt =  builder.build();
		ApiRequest secondApiRequestBuilt =  builder.build();
		
		assertThat(firstApiRequestBuilt)
			.isNotEqualTo(secondApiRequestBuilt);
	}
	
	@Test
	public void shouldCreateApiRequestWithLicenseInfo() {
		ApiRequest apiRequestBuilt = builder.withLicenseInfo("login", "key").build();
		
		assertThat(apiRequestBuilt.getLicenseLogin())
			.isEqualTo("login");
		
		assertThat(apiRequestBuilt.getLicenseKey())
			.isEqualTo("key");
	}
	
	@Test
	public void shouldCreateApiRequestWithPath() {
		
		assertThat(builder.withPath("path").build().getPath())
			.isEqualTo("path");
	}
	
	@Test
	public void shouldCreateApiRequestWithParameters() {
		ApiRequest apiRequestBuilt = 
			builder
				.withParameter("first-key", "first-value")
				.withParameter("second-key", "second-value")
				.build();
		
		assertThat(apiRequestBuilt.getParameters().get("first-key"))
			.isEqualTo("first-value");
		
		assertThat(apiRequestBuilt.getParameters().get("second-key"))
			.isEqualTo("second-value");
	}
	
	@Test
	public void shouldCreateApiRequestWithPathAndQuery() {
		
		assertThat(builder.withPathAndQuery("path-and-query").build().getPathAndQuery())
			.isEqualTo("path-and-query");
	}
}
