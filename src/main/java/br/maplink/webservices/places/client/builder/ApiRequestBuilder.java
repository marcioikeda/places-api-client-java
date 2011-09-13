package br.maplink.webservices.places.client.builder;

import br.maplink.webservices.places.client.entity.ApiRequest;

public interface ApiRequestBuilder {

	public abstract ApiRequest build();

	public abstract ApiRequestBuilder withPathAndQuery(String pathAndQuery);

	public abstract ApiRequestBuilder withParameter(String name, String value);

	public abstract ApiRequestBuilder withPath(String path);

	public abstract ApiRequestBuilder withLicenseInfo(String login, String key);

	public abstract ApiRequestBuilder withHost(String host);

}