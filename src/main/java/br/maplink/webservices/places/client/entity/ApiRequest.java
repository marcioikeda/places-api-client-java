package br.maplink.webservices.places.client.entity;

import java.util.HashMap;

public class ApiRequest {
	private String host;
	private String licenseLogin;
	private String licenseKey;
	private String path;
	private String pathAndQuery;
	private HashMap<String, String> parameters;
	
	public ApiRequest() {
		setParameters(new HashMap<String, String>());
	}
	
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
	public void setPath(String path) {
		this.path = path;
	}
	public String getPath() {
		return path;
	}

	public void setPathAndQuery(String pathAndQuery) {
		this.pathAndQuery = pathAndQuery;
	}

	public String getPathAndQuery() {
		return pathAndQuery;
	}

	public void setParameters(HashMap<String, String> parameters) {
		this.parameters = parameters;
	}

	public HashMap<String, String> getParameters() {
		return parameters;
	}
	
	public boolean hasPathAndQuery() {
		return pathAndQuery != null 
				&& !pathAndQuery.isEmpty();
	}
}
