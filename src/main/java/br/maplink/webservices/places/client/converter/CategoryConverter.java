package br.maplink.webservices.places.client.converter;

import java.util.List;

import br.maplink.webservices.places.client.entity.Category;
import br.maplink.webservices.places.client.resource.Categories;

public interface CategoryConverter {

	public abstract List<Category> toEntity(Categories resource);

}