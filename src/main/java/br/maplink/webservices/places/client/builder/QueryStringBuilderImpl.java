package br.maplink.webservices.places.client.builder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class QueryStringBuilderImpl implements QueryStringBuilder {
	
	@Override
	public String build(HashMap<String, String> parameters) throws UnsupportedEncodingException {
		StringBuffer stringBuffer = new StringBuffer();
		
		Iterator<Map.Entry<String, String>> iterator = parameters.entrySet().iterator();
		
		while(iterator.hasNext()) {
			Map.Entry<String, String> parameter = iterator.next();
			
			stringBuffer.append(
					String.format(
							"%1$s=%2$s", 
							URLEncoder.encode(parameter.getKey(), "utf-8"), 
							URLEncoder.encode(parameter.getValue(), "utf-8")));
			
			if (iterator.hasNext()) {
				stringBuffer.append("&");
            }
		}
		
		if(stringBuffer.length() > 0) {
			stringBuffer.insert(0, "?");
		}
		
		return stringBuffer.toString();
	}
}
