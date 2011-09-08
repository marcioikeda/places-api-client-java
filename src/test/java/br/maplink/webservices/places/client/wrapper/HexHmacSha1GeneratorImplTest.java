package br.maplink.webservices.places.client.wrapper;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class HexHmacSha1GeneratorImplTest {

	private HexHmacSha1GeneratorImpl generator;
	
	@Before
	public void setUp() {
		generator = new HexHmacSha1GeneratorImpl();
	}
	
	@Test
	public void shouldConvertIntoHexHmacSha1Hash() throws InvalidKeyException, NoSuchAlgorithmException{
		String hashGenerated = generator.generateFor("my\ncontent", "my-key");
		
		assertThat(hashGenerated).isEqualTo("34cbdcfcaf9495e1c29a5602aa4ab187370f1799");
	}
}
