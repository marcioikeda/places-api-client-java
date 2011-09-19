package br.com.maplink.webservices.places.client.converter;

import br.com.maplink.webservices.places.client.entity.Category;
import br.com.maplink.webservices.places.client.resource.Categories;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class CategoryConverterImplTest {

	@Test
	public void setUp() {
		Categories resource = new Categories();
		br.com.maplink.webservices.places.client.resource.Category firstCategory = 
			new br.com.maplink.webservices.places.client.resource.Category();
		firstCategory.setId(1);
		firstCategory.setName("first");
		br.com.maplink.webservices.places.client.resource.Category secondCategory = 
			new br.com.maplink.webservices.places.client.resource.Category();
		secondCategory.setId(2);
		secondCategory.setName("second");
		
		resource.getCategories().add(firstCategory);
		resource.getCategories().add(secondCategory);
		
		List<Category> entities = new CategoryConverterImpl().toEntity(resource);
		
		assertThis(firstCategory, entities.get(0));
		assertThis(secondCategory, entities.get(1));
	}
	
	private void assertThis(br.com.maplink.webservices.places.client.resource.Category resource, Category entity) {
		
		assertThat(entity.getId())
			.isEqualTo(resource.getId());
		
		assertThat(entity.getName())
			.isEqualTo(resource.getName());
	}
}
