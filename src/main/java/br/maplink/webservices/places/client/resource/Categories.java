package br.maplink.webservices.places.client.resource;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("categories")
public class Categories {
	
	@XStreamImplicit(itemFieldName="category")
	private List<Category> categories;

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Category> getCategories() {
		return categories;
	}
}
