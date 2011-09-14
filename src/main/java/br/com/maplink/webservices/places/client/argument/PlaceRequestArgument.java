package br.com.maplink.webservices.places.client.argument;

public class PlaceRequestArgument {
	
	private double radius;
	private double latitude;
	private double longitude;
	private String filterTerm;
	private int filterCategory;
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getFilterTerm() {
		return filterTerm;
	}
	public void setFilterTerm(String filterTerm) {
		this.filterTerm = filterTerm;
	}
	public int getFilterCategory() {
		return filterCategory;
	}
	public void setFilterCategory(int filterCategory) {
		this.filterCategory = filterCategory;
	}
}
