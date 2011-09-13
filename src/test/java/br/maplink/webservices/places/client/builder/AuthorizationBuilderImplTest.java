package br.maplink.webservices.places.client.builder;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;

import br.maplink.webservices.places.client.helper.Base64Encoder;
import br.maplink.webservices.places.client.helper.HexHmacSha1Generator;

public class AuthorizationBuilderImplTest {
	
	private static final String RFC1132DATE = "rfc1132date";
	private static final String URI = "uri";
	private static final String LICENSE_LOGIN = "license-login";
	private static final String LICENSE_KEY = "license-key";
	private static final String SIGNATURE_BUILT = "signature-built";
	private static final String BASE64_AUTHORIZATION_BUILT = "base64-authorization-built";

	private HexHmacSha1Generator mockedHexHmacSha1Generator;
	private Base64Encoder mockedBase64Encoder;
	private AuthorizationBuilderImpl authorizationBuilder;
	private String authorizationBuilt;

	@Before
	public void setUp() {
		mockedHexHmacSha1Generator = mock(HexHmacSha1Generator.class);
		mockedBase64Encoder = mock(Base64Encoder.class);
		
		authorizationBuilder = new AuthorizationBuilderImpl(mockedHexHmacSha1Generator, mockedBase64Encoder);
	}
	
	@Test
	public void shouldBuildAuthorization() throws Exception {
		givenSignatureWasGenerated()
			.andAuthorizationBaseWasEncoded()
			.whenBuildingAuthorization();
		
		assertThat(authorizationBuilt)
			.isEqualTo("MAPLINKWS base64-authorization-built");
	}
	
	@Test
	public void shouldGenerateSignatureWhenBuildingAuthorization() throws Exception {
		givenSignatureWasGenerated()
			.andAuthorizationBaseWasEncoded()
			.whenBuildingAuthorization();
		
		verify(mockedHexHmacSha1Generator, times(1)).generateFor("GET\nrfc1132date\nuri\nlicense-login", LICENSE_KEY);
	}
	
	@Test
	public void shouldEncodeAuthorizationBaseToBase63WhenBuildingAuthorization() throws Exception {
		givenSignatureWasGenerated()
			.andAuthorizationBaseWasEncoded()
			.whenBuildingAuthorization();
		
		verify(mockedBase64Encoder, times(1)).encode("license-login:signature-built");
	}

	private AuthorizationBuilderImplTest givenSignatureWasGenerated() throws InvalidKeyException, NoSuchAlgorithmException {
		when(mockedHexHmacSha1Generator.generateFor(anyString(), anyString()))
			.thenReturn(SIGNATURE_BUILT);
		return this;
	}
	
	private AuthorizationBuilderImplTest andAuthorizationBaseWasEncoded() throws Exception {
		when(mockedBase64Encoder.encode(anyString()))
			.thenReturn(BASE64_AUTHORIZATION_BUILT);
		return this;
	}
	
	private void whenBuildingAuthorization() throws Exception {
		authorizationBuilt = authorizationBuilder.build(RFC1132DATE, URI, LICENSE_LOGIN, LICENSE_KEY);
	}
}