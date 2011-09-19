package br.com.maplink.webservices.places.client.builder;

import br.com.maplink.webservices.places.client.helper.Base64Encoder;
import br.com.maplink.webservices.places.client.helper.HexHmacSha1Generator;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AuthorizationHeaderBuilderImpl implements AuthorizationHeaderBuilder {

	private static final String AUTHORIZATION_TEMPLATE = "MAPLINKWS %1$s";
	private static final String SIGNATURE_TEMPLATE = "GET\n%1$s\n%2$s\n%3$s";
	private final HexHmacSha1Generator hexHmaxSha1Generator;
	private final Base64Encoder base64Encoder;
	
	public AuthorizationHeaderBuilderImpl(
			HexHmacSha1Generator hexHmaxSha1Generator,
			Base64Encoder base64Encoder) {
				this.hexHmaxSha1Generator = hexHmaxSha1Generator;
				this.base64Encoder = base64Encoder;
	}
	
	@Override
	public String build(
			String rfc1132Date, 
			String uri, 
			String licenseLogin, 
			String licenseKey) throws InvalidKeyException, NoSuchAlgorithmException{
		
		String signatureContent = createSignatureContent(rfc1132Date, uri, licenseLogin);
		
		String generatedSignature = generateSignature(licenseKey, signatureContent);
		
		String generatedBaseAuthorization = generateAuthorizationBase(licenseLogin, generatedSignature);
		
		return String.format(AUTHORIZATION_TEMPLATE, generatedBaseAuthorization);
	}

	private String generateAuthorizationBase(String licenseLogin,
			String generatedSignature) {
		return base64Encoder
			.encode(
				String.format(
						"%1$s:%2$s",
						licenseLogin, 
						generatedSignature));
	}

	private String generateSignature(String licenseKey, String signatureContent)
			throws InvalidKeyException, NoSuchAlgorithmException {
		return hexHmaxSha1Generator.generateFor(signatureContent, licenseKey);
	}

	private String createSignatureContent(String rfc1132Date, String uri,
			String licenseLogin) {
		return String.format(
				SIGNATURE_TEMPLATE, 
				rfc1132Date,
				uri,
				licenseLogin);
	}
}
