package br.maplink.webservices.places.client.service;

import java.io.IOException;
import java.net.MalformedURLException;

import br.com.tealdi.httpclient.Response;
import br.maplink.webservices.places.client.entity.RequestAuthorization;

public interface HttpResponseRetriever {

	public abstract Response retrieveFor(
			RequestAuthorization requestAuthorization)
			throws MalformedURLException, IOException;

}