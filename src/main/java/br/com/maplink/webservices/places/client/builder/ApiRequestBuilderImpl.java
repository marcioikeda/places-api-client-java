package br.com.maplink.webservices.places.client.builder;

import br.com.maplink.webservices.places.client.entity.ApiRequest;

public class ApiRequestBuilderImpl implements ApiRequestBuilder {

	private ApiRequest apiRequest;

	public ApiRequestBuilderImpl() {
		createDefaultApiRequest();
	}
	
	@Override
	public ApiRequestBuilder withHost(String host) {
		apiRequest.setHost(host);
		
		return this;
	}
	
	@Override
	public ApiRequestBuilder withLicenseInfo(String login, String key) {
		apiRequest.setLicenseLogin(login);
		apiRequest.setLicenseKey(key);
		
		return this;
	}

	@Override
	public ApiRequestBuilder withPath(String path) {
		apiRequest.setPath(path);
		
		return this;
	}

	@Override
	public ApiRequestBuilder withParameter(String name, String value) {
		apiRequest.getParameters().put(name, value);
		
		return this;
	}

	@Override
	public ApiRequestBuilder withPathAndQuery(String pathAndQuery) {
		apiRequest.setPathAndQuery(pathAndQuery);
		
		return this;
	}
	
	@Override
	public ApiRequest build() {
		ApiRequest requestBuilt = apiRequest;
		
		createDefaultApiRequest();
		
		return requestBuilt;
	}

	private void createDefaultApiRequest() {
		apiRequest = new ApiRequest();
	}
}
