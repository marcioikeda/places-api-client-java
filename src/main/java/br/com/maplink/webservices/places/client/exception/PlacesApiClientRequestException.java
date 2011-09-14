package br.com.maplink.webservices.places.client.exception;

import br.com.tealdi.httpclient.Response;

public class PlacesApiClientRequestException extends Exception {

	private static final long serialVersionUID = -6654102886552486913L;

	public PlacesApiClientRequestException(Response response) {
		super(String.format(
				"An error occurred while requesting the webservice. The response was %1$d - %2$s",
				response.getStatusCode(),
				response.getBody()));
	}
}
