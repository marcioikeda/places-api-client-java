package br.com.maplink.webservices.places.client.builder;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class UriBuilderImpl implements UriBuilder {
	
	private final QueryStringBuilder queryStringBuilder;
	
	public UriBuilderImpl(QueryStringBuilder queryStringBuilder) {
		this.queryStringBuilder = queryStringBuilder;		
	}

	@Override
	public String build(String host, String path, HashMap<String, String> parameters) throws UnsupportedEncodingException {
		return String.format(
			"%1$s%2$s%3$s",
			host,
			path,
			queryStringBuilder.build(parameters));
	}

	@Override
	public String build(String host, String pathAndQuery) {
		return String.format("%1$s%2$s", host, pathAndQuery);
	}
}
