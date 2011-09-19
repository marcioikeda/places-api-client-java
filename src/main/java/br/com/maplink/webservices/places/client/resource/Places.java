package br.com.maplink.webservices.places.client.resource;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("places")
public class Places {

	public Places() {
		places = new ArrayList<Place>();
		links = new ArrayList<AtomLink>();
	}
	
	@XStreamImplicit(itemFieldName="place")
	private List<Place> places;
	
	@XStreamAlias("total-found")
	private int totalFound;
	
	@XStreamAlias("start-index")
	private int startIndex;
	
	@XStreamImplicit(itemFieldName="link")
	private List<AtomLink> links;

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

	public List<AtomLink> getLinks() {
		return links;
	}

	public void setLinks(List<AtomLink> links) {
		this.links = links;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getStartIndex() {
		return startIndex;
	}
}
