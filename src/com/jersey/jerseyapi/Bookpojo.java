package com.jersey.jerseyapi;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;;

@SuppressWarnings("serial")
@XmlRootElement(name="books")
public class Bookpojo implements Serializable {
	int id;
	String name,description,author,genre,status;
	Timestamp published_date;
	public Bookpojo(){
		
	}
	public Bookpojo(int id, String name, String description, String author, String genre, String status,
			Timestamp published_date) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.author = author;
		this.genre = genre;
		this.status = status;
		this.published_date = published_date;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getAuthor() {
		return author;
	}
	public String getGenre() {
		return genre;
	}
	public String getStatus() {
		return status;
	}
	public Timestamp getPublished_date() {
		return published_date;
	}
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}
	
	@XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@XmlElement
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@XmlElement
	public void setStatus(String status) {
		this.status = status;
	}
	
	@XmlElement
	public void setPublished_date(Timestamp published_date) {
		this.published_date = published_date;
	}

}
