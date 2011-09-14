package br.com.maplink.webservices.places.client.resource;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("link")
public class AtomLink {
	
	@XStreamAlias("type")
	@XStreamAsAttribute
	private String type;
	
	@XStreamAlias("rel")
	@XStreamAsAttribute
	private String rel;
	
	@XStreamAlias("href")
	@XStreamAsAttribute
	private String href;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
}
