package com.sb.players_app.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player implements Serializable {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String name;
	@Column
	private String country;
	@Column
	private String imageURL;
	
	public Player() {
		
	}

	public Player(long id, String name, String country, String imageURL) {
		this.id = id;
		this.name = name;
		this.country = country;
		this.imageURL = imageURL;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

}
