package br.maplink.webservices.places.client.builder;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class UriBuilderImplTest {
	
	private static final String HOST = "host";
	private static final String PATH = "path";
	private static final String QUERY_STRING_BUILT = "query-string-built";
	private QueryStringBuilder mockedQueryStringBuilder;
	private UriBuilder uriBuilder;
	private HashMap<String, String> parameters;

	@Before
	public void setUp() {
		parameters = new HashMap<String, String>();
		
		mockedQueryStringBuilder = mock(QueryStringBuilder.class);
		uriBuilder = new UriBuilderImpl(mockedQueryStringBuilder);
	}
	
	@Test
	public void shouldBuildUri() throws UnsupportedEncodingException {
		givenQueryStringWereBuilt();
		
		assertThat(uriBuilder.build(HOST, PATH, parameters))
			.isEqualTo(String.format("hostpathquery-string-built"));
	}
	
	@Test
	public void shouldBuildQueryStringWhenBuildingUri() throws UnsupportedEncodingException {
		givenQueryStringWereBuilt();
		
		uriBuilder.build(HOST, PATH, parameters);

		verify(mockedQueryStringBuilder, times(1)).build(parameters);
	}

	private void givenQueryStringWereBuilt() throws UnsupportedEncodingException {
		when(mockedQueryStringBuilder.build((HashMap<String, String>) isA(HashMap.class)))
			.thenReturn(QUERY_STRING_BUILT);
	}
}
