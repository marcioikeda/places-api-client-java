package br.maplink.webservices.places.client.entity;

public class PlacesApiRequest {

	private String host;
	private String licenseLogin;
	private String licenseKey;
	
	private void setHost(String host) {
		this.host = host;
	}
	
	private String getHost() {
		return host;
	}
	
	private void setLicenseLogin(String licenseLogin) {
		this.licenseLogin = licenseLogin;
	}
	
	private String getLicenseLogin() {
		return licenseLogin;
	}
	
	private void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}
	
	private String getLicenseKey() {
		return licenseKey;
	}
}
