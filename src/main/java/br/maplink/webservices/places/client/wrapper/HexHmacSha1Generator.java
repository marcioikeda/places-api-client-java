package br.maplink.webservices.places.client.wrapper;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface HexHmacSha1Generator {

	public abstract String generateFor(String content, String key)
			throws InvalidKeyException, NoSuchAlgorithmException;

}