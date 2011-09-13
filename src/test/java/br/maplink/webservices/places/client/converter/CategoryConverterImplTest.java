package br.maplink.webservices.places.client.converter;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import br.maplink.webservices.places.client.entity.Category;
import br.maplink.webservices.places.client.resource.Categories;

public class CategoryConverterImplTest {

	@Test
	public void setUp() {
		Categories resource = new Categories();
		br.maplink.webservices.places.client.resource.Category firstCategory = 
			new br.maplink.webservices.places.client.resource.Category();
		firstCategory.setId(1);
		firstCategory.setName("first");
		br.maplink.webservices.places.client.resource.Category secondCategory = 
			new br.maplink.webservices.places.client.resource.Category();
		secondCategory.setId(2);
		secondCategory.setName("second");
		
		resource.getCategories().add(firstCategory);
		resource.getCategories().add(secondCategory);
		
		List<Category> entities = new CategoryConverterImpl().toEntity(resource);
		
		assertThis(firstCategory, entities.get(0));
		assertThis(secondCategory, entities.get(1));
	}
	
	private void assertThis(br.maplink.webservices.places.client.resource.Category resource, Category entity) {
		
		assertThat(entity.getId())
			.isEqualTo(resource.getId());
		
		assertThat(entity.getName())
			.isEqualTo(resource.getName());
	}
}
