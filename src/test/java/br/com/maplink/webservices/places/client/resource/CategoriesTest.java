package br.com.maplink.webservices.places.client.resource;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import br.com.maplink.webservices.places.client.resource.Categories;
import br.com.maplink.webservices.places.client.wrapper.XmlSerializerWrapper;
import br.com.maplink.webservices.places.client.wrapper.XmlSerializerWrapperImpl;

public class CategoriesTest {
	
	@Test
	public void shouldDeserializeFromXml() {
		XmlSerializerWrapper serializer = new XmlSerializerWrapperImpl();
		
		String categoryInXml = "<categories><category><id>42</id></category><category><id>43</id></category></categories>";
		
		Categories categoriesDeserialized = serializer.deserialize(Categories.class, categoryInXml);
		
		assertThat(categoriesDeserialized.getCategories())
			.hasSize(2);

		assertThat(categoriesDeserialized.getCategories().get(0).getId())
			.isEqualTo(42);
		
		assertThat(categoriesDeserialized.getCategories().get(1).getId())
			.isEqualTo(43);
	}
}
