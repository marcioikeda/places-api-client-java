package br.maplink.webservices.places.client.resource;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import br.maplink.webservices.places.client.wrapper.XmlSerializerWrapper;

public class CategoryTest {
	
	@Test
	public void shouldDeserializeFromXml() {
		XmlSerializerWrapper serializer = new XmlSerializerWrapper();
		
		String categoryInXml = "<category><id>42</id><name>a-name</name></category>";
		
		Category categoryDeserialized = (Category) serializer.deserialize(categoryInXml);
		
		assertThat(categoryDeserialized.getId())
			.isEqualTo(42);

		assertThat(categoryDeserialized.getName())
			.isEqualTo("a-name");
	}
}
