package br.com.maplink.webservices.places.client.resource;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

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
