package br.maplink.webservices.places.client.converter;

import java.util.ArrayList;
import java.util.List;

import br.maplink.webservices.places.client.entity.Category;
import br.maplink.webservices.places.client.resource.Categories;

public class CategoryConverterImpl implements CategoryConverter {

	
	@Override
	public List<Category> toEntity(Categories resource) {
		
		List<Category> categories = new ArrayList<Category>();
		
		for(br.maplink.webservices.places.client.resource.Category categoryResource :  resource.getCategories()) {
			Category categoryConverted = new Category();
			categoryConverted.setId(categoryResource.getId());
			categoryConverted.setName(categoryResource.getName());
			
			categories.add(categoryConverted);
		}
		
		return categories;
	}
}
