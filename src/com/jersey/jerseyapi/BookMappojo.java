package com.jersey.jerseyapi;

import java.sql.Timestamp;

public class BookMappojo {
	String user_name,status;
	int book_id;
	Timestamp borrowed_date,return_date;
	
	public BookMappojo(){
		
	}
	public BookMappojo(String user_name, String status, int book_id, Timestamp borrowed_date, Timestamp return_date) {
		super();
		this.user_name = user_name;
		this.status = status;
		this.book_id = book_id;
		this.borrowed_date = borrowed_date;
		this.return_date = return_date;
	}
	public String getUser_name() {
		return user_name;
	}
	public String getStatus() {
		return status;
	}
	public int getBook_id() {
		return book_id;
	}
	public Timestamp getBorrowed_date() {
		return borrowed_date;
	}
	public Timestamp getReturn_date() {
		return return_date;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public void setBorrowed_date(Timestamp borrowed_date) {
		this.borrowed_date = borrowed_date;
	}
	public void setReturn_date(Timestamp return_date) {
		this.return_date = return_date;
	}
	
	
}
