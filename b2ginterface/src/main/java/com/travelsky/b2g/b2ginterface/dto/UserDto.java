package com.travelsky.b2g.b2ginterface.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

@JacksonXmlRootElement
public class UserDto  implements Serializable{

	private static final long serialVersionUID = -2319246616907615120L;
	
	@JacksonXmlProperty(localName = "id")
    @JacksonXmlElementWrapper(useWrapping = false) 
	private String id;
	private String name;
	private String state;



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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
