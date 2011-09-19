package br.com.maplink.webservices.places.client.resource;

import br.com.maplink.webservices.places.client.wrapper.XmlSerializerWrapper;
import br.com.maplink.webservices.places.client.wrapper.XmlSerializerWrapperImpl;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class AtomLinkTest {

	@Test
	public void shouldDeserialize() {
		XmlSerializerWrapper serializer = new XmlSerializerWrapperImpl();
		
		String xmlAtomLinkResource = "<link type=\"type\" rel=\"rel\" href=\"href\" />";
		
		AtomLink resource = serializer.deserialize(AtomLink.class, xmlAtomLinkResource);
		
		assertThat(resource.getType())
			.isEqualTo("type");
		assertThat(resource.getRel())
			.isEqualTo("rel");
		assertThat(resource.getHref())
			.isEqualTo("href");
	}
}
