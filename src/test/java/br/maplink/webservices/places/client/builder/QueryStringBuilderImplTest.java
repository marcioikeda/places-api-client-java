package br.maplink.webservices.places.client.builder;

import static org.fest.assertions.Assertions.assertThat;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import br.maplink.webservices.places.client.builder.QueryStringBuilder;
import br.maplink.webservices.places.client.builder.QueryStringBuilderImpl;

public class QueryStringBuilderImplTest {

	private QueryStringBuilder builder;

	@Before
	public void setUp() {
		builder = new QueryStringBuilderImpl();
	}
	
	@Test
	public void shouldCreateAQueryStringForAPopulatedHashMap() throws UnsupportedEncodingException {
		HashMap<String, String> parameters = new HashMap<String, String>();
		parameters.put("first key", "first-value");
		parameters.put("second-key", "second value");
		
		assertThat(builder.build(parameters))
			.isEqualTo("?second-key=second+value&first+key=first-value");
	}
	
	@Test
	public void shouldNotCreateAQueryStringForAEmptyHashMap() throws UnsupportedEncodingException {
		HashMap<String, String> parameters = new HashMap<String, String>();
		
		assertThat(builder.build(parameters))
			.isEqualTo("");
	}
}
