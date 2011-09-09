package br.maplink.webservices.places.client.helper;

import java.util.Collection;
import java.util.Iterator;

public class StringHelperImpl implements StringHelper {

	@Override
	public String join(Collection<String> collection, String delimiter) {
        StringBuffer buffer = new StringBuffer();
        
        Iterator<String> hashMapIterator = collection.iterator();
        
        while (hashMapIterator.hasNext()) {
            buffer.append(hashMapIterator.next());
            
            if (hashMapIterator.hasNext()) {
                buffer.append(delimiter);
            }
        }
        return buffer.toString();
    }
}
