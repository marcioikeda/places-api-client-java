package br.com.maplink.webservices.places.client.resource;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("category")
public class Category {
	
	@XStreamAlias("id")
	private int id;
	@XStreamAlias("name")
	private String name;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
