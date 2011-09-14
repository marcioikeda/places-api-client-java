package br.com.maplink.webservices.places.client.entity;

public class RequestAuthorization {
	private String authorization;
	private String dateInRfc1132;
	private String uri;

	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	public String getAuthorization() {
		return authorization;
	}
	public void setDateInRfc1132(String dateInRfc1132) {
		this.dateInRfc1132 = dateInRfc1132;
	}
	public String getDateInRfc1132() {
		return dateInRfc1132;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getUri() {
		return uri;
	}
}
