package br.maplink.webservices.places.client.resource;

import java.util.ArrayList;
import java.util.List;

import br.maplink.webservices.places.client.resource.Category;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("categories")
public class Categories {
	
	public Categories(){
		categories = new ArrayList<Category>();
	}
	
	@XStreamImplicit(itemFieldName="category")
	private List<Category> categories;

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Category> getCategories() {
		return categories;
	}
}
