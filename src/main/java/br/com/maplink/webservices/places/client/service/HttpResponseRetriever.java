package br.com.maplink.webservices.places.client.service;

import br.com.maplink.webservices.places.client.entity.RequestAuthorization;
import br.com.tealdi.httpclient.Response;

import java.io.IOException;

public interface HttpResponseRetriever {

	public abstract Response retrieveFor(
			RequestAuthorization requestAuthorization)
			throws IOException;

}