package br.com.maplink.webservices.places.client.wrapper;

import br.com.maplink.webservices.places.client.resource.Categories;
import br.com.maplink.webservices.places.client.resource.Category;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlSerializerWrapperImpl implements XmlSerializerWrapper {

	private XStream xstream;

	public XmlSerializerWrapperImpl() {
		xstream = new XStream(new DomDriver("UTF-8"));
		xstream.processAnnotations(Category.class);
		xstream.processAnnotations(Categories.class);
	}
	
	@Override
	public <T> T deserialize(Class<T> klazz, String xml) {
		return klazz.cast(xstream.fromXML(xml));
	}
	
	@Override
	public String serialize(Object object) {
		return xstream.toXML(object);
	}
}
