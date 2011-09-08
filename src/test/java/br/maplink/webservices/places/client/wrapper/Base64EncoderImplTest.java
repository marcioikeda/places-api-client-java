package br.maplink.webservices.places.client.wrapper;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class Base64EncoderImplTest {

	private Base64EncoderImpl encoder;

	@Before
	public void setUp() {
		encoder = new Base64EncoderImpl(); 
	}
	
	@Test
	public void shouldEncodeToBase64() throws Exception {
		assertThat(encoder.encode("my-content"))
			.isEqualTo("bXktY29udGVudA==");
	}
}
