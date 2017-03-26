package com.travelsky.b2g.b2ginterface.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

@JacksonXmlRootElement
public class UserPageDto extends UserDto implements Serializable{

	private static final long serialVersionUID = -2319246616907615120L;

	private  int page;
	private  int size;
	private String direction;
	private String[] properties;

	public UserPageDto() {
	}

	public UserPageDto(int page, int size, String direction, String... properties) {
		this.page = page;
		this.size = size;
		this.direction = direction;
		this.properties = properties;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String[] getProperties() {
		return properties;
	}

	public void setProperties(String[] properties) {
		this.properties = properties;
	}
}
