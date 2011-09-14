package br.com.maplink.webservices.places.client.helper;

import org.junit.Before;
import org.junit.Test;

import br.com.maplink.webservices.places.client.helper.Base64Encoder;
import br.com.maplink.webservices.places.client.helper.Base64EncoderImpl;

import static org.fest.assertions.Assertions.assertThat;

public class Base64EncoderImplTest {

	private Base64Encoder encoder;

	@Before
	public void setUp() {
		encoder = new Base64EncoderImpl(); 
	}
	
	@Test
	public void shouldEncodeToBase64() throws Exception {
		assertThat(encoder.encode("my-content"))
			.isEqualTo("bXktY29udGVudA==");
	}
	
	@Test
	public void shouldDecodeFromBase64() throws Exception {
		assertThat(encoder.decode("bXktY29udGVudA=="))
			.isEqualTo("my-content");
	}
}
