package br.maplink.webservices.places.client.wrapper;

public interface Base64Encoder {

	public abstract String encode(String content) throws Exception;
	public abstract String decode(String contentInBase64) throws Exception;

}