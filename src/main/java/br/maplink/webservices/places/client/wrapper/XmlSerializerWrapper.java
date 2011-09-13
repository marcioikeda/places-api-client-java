package br.maplink.webservices.places.client.wrapper;

import br.maplink.webservices.places.client.resource.Category;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlSerializerWrapper {

	private XStream xstream;

	public XmlSerializerWrapper() {
		xstream = new XStream(new DomDriver("UTF-8"));
		xstream.processAnnotations(Category.class);
	}
	
	public Object deserialize(String xml) {
		return xstream.fromXML(xml);
	}
	
	public String serialize(Object object) {
		return xstream.toXML(object);
	}
}
