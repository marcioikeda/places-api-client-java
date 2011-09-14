package br.com.maplink.webservices.places.client.resource;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("place")
public class Place {
	@XStreamAlias("id")
	private String id;
	
	@XStreamAlias("name")
    private String name;
	
	@XStreamAlias("description")
    private String description;
	
	@XStreamAlias("address")
    private String address;
	
	@XStreamAlias("district")
    private String district;
	
	@XStreamAlias("city")
    private String city;

	@XStreamAlias("state")
	private String state;

    @XStreamAlias("country")
    private String country;

    @XStreamAlias("zip-code")
    private String zipCode;

    @XStreamAlias("phone")
    private String primaryPhone;

    @XStreamAlias("secondary-phone")
    private String secondaryPhone;

    @XStreamAlias("category")
    private String category;

    @XStreamAlias("sub-category")
    private String subCategory;

    @XStreamAlias("latitude")
    private double latitude;

    @XStreamAlias("longitude")
    private double longitude;

    @XStreamAlias("distance")
    private double distance;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getSecondaryPhone() {
		return secondaryPhone;
	}

	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
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

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
}
