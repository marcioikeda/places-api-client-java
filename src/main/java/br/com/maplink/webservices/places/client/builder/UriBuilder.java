package br.com.maplink.webservices.places.client.builder;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public interface UriBuilder {

	public abstract String build(String host, String path,
			HashMap<String, String> parameters)
			throws UnsupportedEncodingException;
	
	public abstract String build(String host, String pathAndQuery);
}