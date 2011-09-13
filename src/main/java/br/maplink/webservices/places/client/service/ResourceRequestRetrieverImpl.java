package br.maplink.webservices.places.client.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import br.com.tealdi.httpclient.Response;
import br.maplink.webservices.places.client.builder.RequestAuthorizationBuilder;
import br.maplink.webservices.places.client.entity.ApiRequest;
import br.maplink.webservices.places.client.exception.PlacesApiClientRequestException;
import br.maplink.webservices.places.client.wrapper.XmlSerializerWrapper;

public class ResourceRequestRetrieverImpl implements ResourceRequestRetriever {

	private final RequestAuthorizationBuilder requestAuthorizationBuilder;
	private final HttpResponseRetriever httpResponseRetriever;
	private final XmlSerializerWrapper xmlSerializerWrapper;

	public ResourceRequestRetrieverImpl(
			RequestAuthorizationBuilder requestAuthorizationBuilder,
			HttpResponseRetriever httpResponseRetriever,
			XmlSerializerWrapper xmlSerializerWrapper) {
				this.requestAuthorizationBuilder = requestAuthorizationBuilder;
				this.httpResponseRetriever = httpResponseRetriever;
				this.xmlSerializerWrapper = xmlSerializerWrapper;
	}

	@Override
	public <T> T retrieve(Class<T> klazz, ApiRequest apiRequest) 
	throws 
		InvalidKeyException, 
		NoSuchAlgorithmException, 
		MalformedURLException, 
		IOException, 
		PlacesApiClientRequestException {
		
		Response response = 
			httpResponseRetriever
				.retrieveFor(requestAuthorizationBuilder.build(apiRequest));
		
		checkStatusCodeFrom(response);
		
		return xmlSerializerWrapper.deserialize(klazz, response.getBody());
	}

	private void checkStatusCodeFrom(Response response) throws PlacesApiClientRequestException {
		if(isItInvalid(response)) {
			throw new PlacesApiClientRequestException(response);
		}
	}

	private boolean isItInvalid(Response response) {
		return !response.success() && response.getStatusCode() != 404;
	}
}
