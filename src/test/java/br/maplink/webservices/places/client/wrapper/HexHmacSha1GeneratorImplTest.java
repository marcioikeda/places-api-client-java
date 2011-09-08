package br.maplink.webservices.places.client.wrapper;

import static org.fest.assertions.Assertions.assertThat;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class HexHmacSha1GeneratorImplTest {
	
	@Test
	public void shouldConvertIntoHexHmacSha1Hash() throws InvalidKeyException, NoSuchAlgorithmException{
		String hashGenerated = new HexHmacSha1GeneratorImpl().generateFor("my\ncontent", "my-key");
		
		assertThat(hashGenerated).isEqualTo("34cbdcfcaf9495e1c29a5602aa4ab187370f1799");
	}
}
