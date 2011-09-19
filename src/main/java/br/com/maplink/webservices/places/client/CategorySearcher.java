package br.com.maplink.webservices.places.client;

import br.com.maplink.webservices.places.client.entity.Category;
import br.com.maplink.webservices.places.client.entity.PlacesApiRequest;
import br.com.maplink.webservices.places.client.exception.PlacesApiClientRequestException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface CategorySearcher {

	public abstract List<Category> all(PlacesApiRequest placeApiRequest)
			throws InvalidKeyException, NoSuchAlgorithmException,
			IOException, PlacesApiClientRequestException;

}