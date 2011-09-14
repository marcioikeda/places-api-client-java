package br.com.maplink.webservices.places.client.entity;

public class PlacesApiRequest {

	private String host;
	private String licenseLogin;
	private String licenseKey;
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public String getHost() {
		return host;
	}
	
	public void setLicenseLogin(String licenseLogin) {
		this.licenseLogin = licenseLogin;
	}
	
	public String getLicenseLogin() {
		return licenseLogin;
	}
	
	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}
	
	public String getLicenseKey() {
		return licenseKey;
	}
}
