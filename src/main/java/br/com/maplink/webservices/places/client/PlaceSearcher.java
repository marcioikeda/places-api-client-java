package br.com.maplink.webservices.places.client;

import br.com.maplink.webservices.places.client.argument.PlaceRequestArgument;
import br.com.maplink.webservices.places.client.entity.PlacesApiRequest;
import br.com.maplink.webservices.places.client.entity.PlacesResult;
import br.com.maplink.webservices.places.client.exception.PlacesApiClientRequestException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface PlaceSearcher {

	public abstract PlacesResult byRadius(PlacesApiRequest placesApiRequest,
			PlaceRequestArgument requestArgument)
			throws InvalidKeyException, NoSuchAlgorithmException,
			IOException, PlacesApiClientRequestException;

	public abstract PlacesResult byTerm(PlacesApiRequest placesApiRequest,
			PlaceRequestArgument requestArgument)
			throws InvalidKeyException, NoSuchAlgorithmException,
			IOException, PlacesApiClientRequestException;

	public abstract PlacesResult byCategory(PlacesApiRequest placesApiRequest,
			PlaceRequestArgument requestArgument)
			throws InvalidKeyException, NoSuchAlgorithmException,
			IOException, PlacesApiClientRequestException;

	public abstract PlacesResult forPaginationPath(PlacesApiRequest placesApiRequest, String paginationPath)
			throws InvalidKeyException, NoSuchAlgorithmException,
			IOException, PlacesApiClientRequestException;

}