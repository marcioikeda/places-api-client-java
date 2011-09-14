package br.com.maplink.webservices.places.client.converter;

import java.util.List;

import br.com.maplink.webservices.places.client.entity.Category;
import br.com.maplink.webservices.places.client.resource.Categories;

public interface CategoryConverter {

	public abstract List<Category> toEntity(Categories resource);

}