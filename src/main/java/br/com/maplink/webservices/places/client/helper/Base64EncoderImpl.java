package br.com.maplink.webservices.places.client.helper;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class Base64EncoderImpl implements Base64Encoder {

	@Override
	public String encode(String content) {
		return new BASE64Encoder().encode(content.getBytes());
	}

	@Override
	public String decode(String contentInBase64) throws IOException {
		return new String(new BASE64Decoder().decodeBuffer(contentInBase64));
	}
}
