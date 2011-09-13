package br.maplink.webservices.places.client.builder;

public interface AuthorizationBuilder {

	public abstract String build(
			String rfc1132Date, 
			String uri,
			String licenseLogin, 
			String licenseKey) throws Exception;

}