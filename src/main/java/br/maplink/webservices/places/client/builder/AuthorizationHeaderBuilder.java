package br.maplink.webservices.places.client.builder;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface AuthorizationHeaderBuilder {

	public abstract String build(
			String rfc1132Date, 
			String uri,
			String licenseLogin, 
			String licenseKey) throws InvalidKeyException, NoSuchAlgorithmException;

}