package br.com.maplink.webservices.places.client.converter;

import br.com.maplink.webservices.places.client.entity.PlacesResult;
import br.com.maplink.webservices.places.client.resource.Places;

public interface PlacesConverter {

	public abstract PlacesResult toEntity(Places resource);

}