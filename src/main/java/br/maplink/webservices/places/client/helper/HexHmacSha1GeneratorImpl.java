package br.maplink.webservices.places.client.helper;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HexHmacSha1GeneratorImpl implements HexHmacSha1Generator {

	@Override
	public String generateFor(String content, String key) throws InvalidKeyException, NoSuchAlgorithmException {
		
		SecretKeySpec signingKey = generateKey(key);
        
        byte[] resultHmacInBytes = generateHash(signingKey, content);
		
		return toHexString(resultHmacInBytes);
	}
	
	private byte[] generateHash(SecretKeySpec signingKey, String content) throws NoSuchAlgorithmException, InvalidKeyException {
		Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(signingKey);
        
        return mac.doFinal(content.getBytes());
	}

	private SecretKeySpec generateKey(String key) {
		return new SecretKeySpec(key.getBytes(), "HmacSHA1");
	}
	
	private String toHexString(byte[] content) {
		StringBuffer contentInHex = new StringBuffer();
		
		for (byte aByte : content) {
			String convertedToHexString = Integer.toHexString(0xFF & aByte);
			
			if (convertedToHexString.length() == 1) {
				contentInHex.append('0');
			}
			contentInHex.append(convertedToHexString);
		}

		return contentInHex.toString();
	}
}
