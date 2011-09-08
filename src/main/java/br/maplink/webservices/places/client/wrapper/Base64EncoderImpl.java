package br.maplink.webservices.places.client.wrapper;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;

public class Base64EncoderImpl implements Base64Encoder {

	@Override
	public String encode(String content) throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        
		OutputStream base64OutputStream = MimeUtility.encode(outputStream, "base64");
        
		base64OutputStream.write(content.getBytes());
        base64OutputStream.close();
        
        return outputStream.toString();
	}

	@Override
	public String deconde(String contentInBase64) {
		// TODO Auto-generated method stub
		return null;
	}
}
