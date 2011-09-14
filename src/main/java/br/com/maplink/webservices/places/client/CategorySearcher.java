package br.com.maplink.webservices.places.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import br.com.maplink.webservices.places.client.entity.Category;
import br.com.maplink.webservices.places.client.entity.PlacesApiRequest;
import br.com.maplink.webservices.places.client.exception.PlacesApiClientRequestException;

public interface CategorySearcher {

	public abstract List<Category> all(PlacesApiRequest placeApiRequest)
			throws InvalidKeyException, NoSuchAlgorithmException,
			MalformedURLException, IOException, PlacesApiClientRequestException;

}