package br.com.maplink.webservices.places.client.converter;

import br.com.maplink.webservices.places.client.entity.Category;
import br.com.maplink.webservices.places.client.resource.Categories;

import java.util.List;

public interface CategoryConverter {

	public abstract List<Category> toEntity(Categories resource);

}