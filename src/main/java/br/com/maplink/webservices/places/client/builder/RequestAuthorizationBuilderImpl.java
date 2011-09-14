package br.com.maplink.webservices.places.client.builder;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import br.com.maplink.webservices.places.client.entity.ApiRequest;
import br.com.maplink.webservices.places.client.entity.RequestAuthorization;

public class RequestAuthorizationBuilderImpl implements RequestAuthorizationBuilder {

	private final AuthorizationRfc1132DateGenerator authorizationRfc1132DateGenerator;
	private final UriBuilder uriBuilder;
	private final AuthorizationHeaderBuilder authorizationHeaderBuilder;

	public RequestAuthorizationBuilderImpl(
			AuthorizationRfc1132DateGenerator authorizationRfc1132DateGenerator,
			UriBuilder uriBuilder,
			AuthorizationHeaderBuilder authorizationHeaderBuilder) {
				this.authorizationRfc1132DateGenerator = authorizationRfc1132DateGenerator;
				this.uriBuilder = uriBuilder;
				this.authorizationHeaderBuilder = authorizationHeaderBuilder;
	}
	
	@Override
	public RequestAuthorization build(ApiRequest apiRequest) 
		throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException {
		
		String date = authorizationRfc1132DateGenerator.build();
		
		String uri = generateUri(apiRequest);
		
		String authorizationHeader = 
			authorizationHeaderBuilder
				.build(date, uri, apiRequest.getLicenseLogin(), apiRequest.getLicenseKey());
		
		return createAuthorization(date, uri, authorizationHeader);
	}

	private String generateUri(ApiRequest apiRequest)
			throws UnsupportedEncodingException {
		String uri;
		if(apiRequest.hasPathAndQuery())  {
			uri = uriBuilder.build(apiRequest.getHost(), apiRequest.getPathAndQuery());
		} else {
			uri = uriBuilder.build(apiRequest.getHost(), apiRequest.getPath(), apiRequest.getParameters());
		}
		return uri;
	}

	private RequestAuthorization createAuthorization(String date, String uri,
			String authorizationHeader) {
		RequestAuthorization authorization = new RequestAuthorization();
		
		authorization.setDateInRfc1132(date);
		authorization.setUri(uri);
		authorization.setAuthorization(authorizationHeader);
		
		return authorization;
	}
}
