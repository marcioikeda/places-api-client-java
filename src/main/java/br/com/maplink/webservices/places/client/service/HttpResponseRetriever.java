package br.com.maplink.webservices.places.client.service;

import java.io.IOException;
import java.net.MalformedURLException;

import br.com.maplink.webservices.places.client.entity.RequestAuthorization;
import br.com.tealdi.httpclient.Response;

public interface HttpResponseRetriever {

	public abstract Response retrieveFor(
			RequestAuthorization requestAuthorization)
			throws MalformedURLException, IOException;

}