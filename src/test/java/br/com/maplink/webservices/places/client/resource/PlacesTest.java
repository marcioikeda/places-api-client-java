package br.com.maplink.webservices.places.client.resource;

import br.com.maplink.webservices.places.client.wrapper.XmlSerializerWrapper;
import br.com.maplink.webservices.places.client.wrapper.XmlSerializerWrapperImpl;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PlacesTest {

	@Test
	public void shouldDeserialize() {
		XmlSerializerWrapper serializer = new XmlSerializerWrapperImpl();
		
		String xmlPlacesResource = "<places xmlns:atom=\"http://www.w3.org/2005/Atom\">" +
				"<place><id>42</id></place>" +
				"<place><id>43</id></place>" +
				"<total-found>2</total-found>" +
				"<atom:link  type=\"application/xml\" rel=\"next\" href=\"href-1\" />" +
				"<atom:link  type=\"application/xml\" rel=\"previous\" href=\"href-2\" />" +
				"</places>";
		
		Places resource = serializer.deserialize(Places.class, xmlPlacesResource);
		
		assertThat(resource.getTotalFound())
			.isEqualTo(2);
		assertThat(resource.getPlaces())
			.hasSize(2);
		assertThat(resource.getLinks())
			.hasSize(2);
	}
}
