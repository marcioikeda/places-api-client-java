package br.com.maplink.webservices.places.client.service;

import br.com.maplink.webservices.places.client.entity.ApiRequest;
import br.com.maplink.webservices.places.client.exception.PlacesApiClientRequestException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface ResourceRequestRetriever {

	public abstract <T> T retrieve(Class<T> klazz, ApiRequest apiRequest)
			throws InvalidKeyException, NoSuchAlgorithmException,
            IOException, PlacesApiClientRequestException;

}