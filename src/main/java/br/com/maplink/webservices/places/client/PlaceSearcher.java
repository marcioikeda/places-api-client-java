package br.com.maplink.webservices.places.client;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import br.com.maplink.webservices.places.client.argument.PlaceRequestArgument;
import br.com.maplink.webservices.places.client.entity.PlacesApiRequest;
import br.com.maplink.webservices.places.client.entity.PlacesResult;
import br.com.maplink.webservices.places.client.exception.PlacesApiClientRequestException;

public interface PlaceSearcher {

	public abstract PlacesResult byRadius(PlacesApiRequest placesApiRequest,
			PlaceRequestArgument placeRequestArgumenent)
			throws InvalidKeyException, NoSuchAlgorithmException,
			MalformedURLException, IOException, PlacesApiClientRequestException;

	public abstract PlacesResult forPaginationPath(PlacesApiRequest placesApiRequest, String paginationPath)
			throws InvalidKeyException, NoSuchAlgorithmException,
			MalformedURLException, IOException, PlacesApiClientRequestException;

}