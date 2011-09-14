package br.com.maplink.webservices.places.client.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import br.com.maplink.webservices.places.client.entity.ApiRequest;
import br.com.maplink.webservices.places.client.exception.PlacesApiClientRequestException;

public interface ResourceRequestRetriever {

	public abstract <T> T retrieve(Class<T> klazz, ApiRequest apiRequest)
			throws InvalidKeyException, NoSuchAlgorithmException,
			MalformedURLException, IOException, PlacesApiClientRequestException;

}