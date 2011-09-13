package br.maplink.webservices.places.client.helper;

import java.io.IOException;

public interface Base64Encoder {

	public abstract String encode(String content);
	public abstract String decode(String contentInBase64) throws IOException;

}