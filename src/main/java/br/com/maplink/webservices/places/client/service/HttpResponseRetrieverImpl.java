package br.com.maplink.webservices.places.client.service;

import br.com.maplink.webservices.places.client.entity.RequestAuthorization;
import br.com.tealdi.httpclient.Request;
import br.com.tealdi.httpclient.RequestClient;
import br.com.tealdi.httpclient.Response;
import br.com.tealdi.httpclient.builder.ABuilderForRequest;

import java.io.IOException;

public class HttpResponseRetrieverImpl implements HttpResponseRetriever {

	private final ABuilderForRequest requestBuilder;
	private final RequestClient httpClient;

	public HttpResponseRetrieverImpl(
			ABuilderForRequest requestBuilder,
			RequestClient httpClient) {
				this.requestBuilder = requestBuilder;
				this.httpClient = httpClient;
	}

	@Override
	public Response retrieveFor(RequestAuthorization requestAuthorization) throws IOException {
		Request request = 
			requestBuilder
				.forThis(requestAuthorization.getUri())
				.withHeaderProperty("Content-Type", "application/xml")
				.withHeaderProperty("Accept", "application/xml")
				.withHeaderProperty("X-Maplink-Date", requestAuthorization.getDateInRfc1132())
				.withHeaderProperty("Authorization", requestAuthorization.getAuthorization())
				.instance();
		
		return httpClient.doGet(request);
	}
}
