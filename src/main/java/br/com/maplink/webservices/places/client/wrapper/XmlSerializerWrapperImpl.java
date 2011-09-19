package br.com.maplink.webservices.places.client.wrapper;

import br.com.maplink.webservices.places.client.resource.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class XmlSerializerWrapperImpl implements XmlSerializerWrapper {

	private static XStream xstream;

    public XmlSerializerWrapperImpl() {
        instantiateSerializer();
    }
	
	@Override
	public <T> T deserialize(Class<T> klazz, String xml) {
		return klazz.cast(xstream.fromXML(xml));
	}
	
	@Override
	public String serialize(Object object) {
		return xstream.toXML(object);
	}

    private static void instantiateSerializer() {
        if(xstream != null) {
            return;
        }

        xstream = new XStream(new StaxDriver(new QNameMap()));
		xstream.processAnnotations(Category.class);
		xstream.processAnnotations(Categories.class);
		xstream.processAnnotations(Place.class);
		xstream.processAnnotations(Places.class);
		xstream.processAnnotations(AtomLink.class);
    }
}
