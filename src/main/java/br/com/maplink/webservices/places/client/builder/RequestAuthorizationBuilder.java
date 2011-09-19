package br.com.maplink.webservices.places.client.builder;

import br.com.maplink.webservices.places.client.entity.ApiRequest;
import br.com.maplink.webservices.places.client.entity.RequestAuthorization;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface RequestAuthorizationBuilder {

	public abstract RequestAuthorization build(ApiRequest apiRequest)
			throws UnsupportedEncodingException, InvalidKeyException,
			NoSuchAlgorithmException;

}