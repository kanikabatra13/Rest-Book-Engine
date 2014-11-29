package com.bookengine.ws.service.representation;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import com.bookengine.ws.*;



public abstract class Representation {

	@XmlElement(name="link", namespace="")
	protected List<Link> links;
	
	public List<Link> getLinks() {
		return links;
	}
	
	public void setLinks(Link...links) {
		this.links = Arrays.asList(links);
	}
}
