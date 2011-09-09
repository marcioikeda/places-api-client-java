package br.maplink.webservices.places.client.helper;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public interface QueryStringBuilder {

	public abstract String build(
			HashMap<String, String> parameters)
			throws UnsupportedEncodingException;

}