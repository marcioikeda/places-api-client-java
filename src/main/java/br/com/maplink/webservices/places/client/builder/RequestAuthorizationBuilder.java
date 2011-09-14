package br.com.maplink.webservices.places.client.builder;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import br.com.maplink.webservices.places.client.entity.ApiRequest;
import br.com.maplink.webservices.places.client.entity.RequestAuthorization;

public interface RequestAuthorizationBuilder {

	public abstract RequestAuthorization build(ApiRequest apiRequest)
			throws UnsupportedEncodingException, InvalidKeyException,
			NoSuchAlgorithmException;

}