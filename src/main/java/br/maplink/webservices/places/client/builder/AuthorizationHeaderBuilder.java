package br.maplink.webservices.places.client.builder;

public interface AuthorizationHeaderBuilder {

	public abstract String build(
			String rfc1132Date, 
			String uri,
			String licenseLogin, 
			String licenseKey) throws Exception;

}