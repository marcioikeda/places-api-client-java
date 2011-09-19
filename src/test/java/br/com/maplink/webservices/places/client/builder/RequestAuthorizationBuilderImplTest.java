package br.com.maplink.webservices.places.client.builder;

import br.com.maplink.webservices.places.client.entity.ApiRequest;
import br.com.maplink.webservices.places.client.entity.RequestAuthorization;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

public class RequestAuthorizationBuilderImplTest {

	private static final String DATE_BUILT = "date-built";
	private static final String AUTHORIZATION_HEADER_BUILT = "authorization-header-built";
	private static final String URI_BUILT = "uri-built";
	private static final String HOST = "host";
	private static final String PATH = "path";
	private static final String LICENSE_LOGIN = "license-login";
	private static final String LICENSE_KEY = "license-key";
	private static final String PATH_AND_QUERY = "path-and-query";
	private AuthorizationRfc1132DateGenerator mockedDateGenerator;
	private UriBuilder mockedUriBuilder;
	private AuthorizationHeaderBuilder mockedAuthorizationHeaderBuilder;
	private RequestAuthorizationBuilderImpl builder;
	private ApiRequest apiRequestWithPathAndParameters;
	private RequestAuthorization requestAuthorizationBuilt;
	private ApiRequest apiRequestWithPathAndQuery;

	@Before
	public void setUp() {
		mockedDateGenerator = mock(AuthorizationRfc1132DateGenerator.class);
		mockedUriBuilder = mock(UriBuilder.class);
		mockedAuthorizationHeaderBuilder = mock(AuthorizationHeaderBuilder.class);
		
		builder = new RequestAuthorizationBuilderImpl(mockedDateGenerator, mockedUriBuilder, mockedAuthorizationHeaderBuilder);
	}

	@Test
	public void shouldCreateAnAuthorizationHeaderWithAuthorizationHeaderForARequestWithPathAndParameters() 
		throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
		givenDateWasGenerated()
			.andUriWasBuiltForPathAndParameters()
			.andAuthorizationHeaderWasBuilt()
			.whenBuildingForPathAndParameterRequest();
			
		assertThat(requestAuthorizationBuilt.getAuthorization())
			.isEqualTo(AUTHORIZATION_HEADER_BUILT);
	}
	
	@Test
	public void shouldCreateAuthorizationHeaderWithDateForARequestWithPathAndParameters() 
	throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
		givenDateWasGenerated()
			.andUriWasBuiltForPathAndParameters()
			.andAuthorizationHeaderWasBuilt()
			.whenBuildingForPathAndParameterRequest();

		assertThat(requestAuthorizationBuilt.getDateInRfc1132())
			.isEqualTo(DATE_BUILT);
	}
	
	@Test
	public void shouldCreateAnAuthorizationHeaderWithUriForARequestWithPathAndParameters() 
	throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
		givenDateWasGenerated()
			.andUriWasBuiltForPathAndParameters()
			.andAuthorizationHeaderWasBuilt()
			.whenBuildingForPathAndParameterRequest();
		
		assertThat(requestAuthorizationBuilt.getUri())
			.isEqualTo(URI_BUILT);
	}
	
	@Test
	public void shouldBuildRfc1132DateWhenBuildingARequestWithPathAndParameters() 
	throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
		
		givenDateWasGenerated()
			.andUriWasBuiltForPathAndParameters()
			.andAuthorizationHeaderWasBuilt()
			.whenBuildingForPathAndParameterRequest();

		verify(mockedDateGenerator, times(1)).build();
	}
	
	@Test
	public void shouldBuildUriWhenBuildingARequestWithPathAndParameters() 
	throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
		
		givenDateWasGenerated()
			.andUriWasBuiltForPathAndParameters()
			.andAuthorizationHeaderWasBuilt()
			.whenBuildingForPathAndParameterRequest();
		
		verify(mockedUriBuilder, times(1)).build(HOST, PATH, apiRequestWithPathAndParameters.getParameters());
	}
	
	@Test
	public void shouldBuildAuthorizationHeaderWhenBuildingARequestWithPathAndParameters() 
	throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
		
		givenDateWasGenerated()
			.andUriWasBuiltForPathAndParameters()
			.andAuthorizationHeaderWasBuilt()
			.whenBuildingForPathAndParameterRequest();
		
		verify(mockedAuthorizationHeaderBuilder, times(1))
			.build(DATE_BUILT, URI_BUILT, LICENSE_LOGIN, LICENSE_KEY);
	}
	
	@Test
	public void shouldBuildUriWhenBuildingARequestWithPathAndQuery() 
		throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
		
		givenDateWasGenerated()
			.andUriWasBuiltForPathAndQuery()
			.andAuthorizationHeaderWasBuilt()
			.whenBuildingForPathAndQueryRequest();
		
		verify(mockedUriBuilder, times(1)).build(HOST, PATH_AND_QUERY);
	}
	
	@Test
	public void shouldBuildAuthorizationHeaderWhenBuildingARequestWithPathAndQuery() 
	throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
		
		givenDateWasGenerated()
			.andUriWasBuiltForPathAndQuery()
			.andAuthorizationHeaderWasBuilt()
			.whenBuildingForPathAndQueryRequest();
			
		verify(mockedAuthorizationHeaderBuilder, times(1))
			.build(DATE_BUILT, URI_BUILT, LICENSE_LOGIN, LICENSE_KEY);
	}

	private void whenBuildingForPathAndQueryRequest() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException {
		apiRequestWithPathAndQuery = new ApiRequest();
		apiRequestWithPathAndQuery.setHost(HOST);
		apiRequestWithPathAndQuery.setPathAndQuery(PATH_AND_QUERY);
		apiRequestWithPathAndQuery.setLicenseLogin(LICENSE_LOGIN);
		apiRequestWithPathAndQuery.setLicenseKey(LICENSE_KEY);
		
		requestAuthorizationBuilt = builder.build(apiRequestWithPathAndQuery);
	}

	private RequestAuthorizationBuilderImplTest andUriWasBuiltForPathAndQuery() {
		when(mockedUriBuilder.build(anyString(), anyString()))
			.thenReturn(URI_BUILT);
		
		return this;
	}

	private void whenBuildingForPathAndParameterRequest() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException {
		apiRequestWithPathAndParameters = new ApiRequest();
		apiRequestWithPathAndParameters.setHost(HOST);
		apiRequestWithPathAndParameters.setPath(PATH);
		apiRequestWithPathAndParameters.setLicenseLogin(LICENSE_LOGIN);
		apiRequestWithPathAndParameters.setLicenseKey(LICENSE_KEY);
		
		requestAuthorizationBuilt = builder.build(apiRequestWithPathAndParameters);
	}

	private RequestAuthorizationBuilderImplTest andAuthorizationHeaderWasBuilt() throws InvalidKeyException, NoSuchAlgorithmException {
		when(
				mockedAuthorizationHeaderBuilder
					.build(anyString(), anyString(), anyString(), anyString()))
				.thenReturn(AUTHORIZATION_HEADER_BUILT);
		return this;
	}

	@SuppressWarnings("unchecked")
	private RequestAuthorizationBuilderImplTest andUriWasBuiltForPathAndParameters() throws UnsupportedEncodingException  {
		when(mockedUriBuilder.build(anyString(), anyString(), isA(HashMap.class)))
			.thenReturn(URI_BUILT);
		
		return this;
	}

	private RequestAuthorizationBuilderImplTest givenDateWasGenerated() {
		when(mockedDateGenerator.build())
			.thenReturn(DATE_BUILT);

		return this;
	}
}
