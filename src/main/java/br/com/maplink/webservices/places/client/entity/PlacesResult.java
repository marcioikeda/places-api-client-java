package br.com.maplink.webservices.places.client.entity;

import java.util.List;

public class PlacesResult {

	private List<Place> places;
	private int totalFound;
	private String nextPagePath;
	private String previousPagePath;
	
	public List<Place> getPlaces() {
		return places;
	}
	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	public int getTotalFound() {
		return totalFound;
	}
	public void setTotalFound(int totalFound) {
		this.totalFound = totalFound;
	}
	public String getNextPagePath() {
		return nextPagePath;
	}
	public void setNextPagePath(String nextPagePath) {
		this.nextPagePath = nextPagePath;
	}
	public String getPreviousPagePath() {
		return previousPagePath;
	}
	public void setPreviousPagePath(String previousPagePath) {
		this.previousPagePath = previousPagePath;
	}
}
