package br.com.maplink.webservices.places.client.resource;

import br.com.maplink.webservices.places.client.wrapper.XmlSerializerWrapper;
import br.com.maplink.webservices.places.client.wrapper.XmlSerializerWrapperImpl;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class CategoryTest {
	
	@Test
	public void shouldDeserializeFromXml() {
		XmlSerializerWrapper serializer = new XmlSerializerWrapperImpl();
		
		String categoryInXml = "<category><id>42</id><name>a-name</name></category>";
		
		Category categoryDeserialized = serializer.deserialize(Category.class, categoryInXml);
		
		assertThat(categoryDeserialized.getId())
			.isEqualTo(42);

		assertThat(categoryDeserialized.getName())
			.isEqualTo("a-name");
	}
}
