package com.jersey.jerseyapi;

public class Userpojo {
	String user_name,password,usertype,subscriptiontype;
	int subscription_id,duespaid,pending_dues;
	public Userpojo(){
		
	}
	public Userpojo(String user_name, String password, String usertype, String subscriptiontype, int subscription_id,
			int duespaid, int pending_dues) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.usertype = usertype;
		this.subscriptiontype = subscriptiontype;
		this.subscription_id = subscription_id;
		this.duespaid = duespaid;
		this.pending_dues = pending_dues;
	}
	public String getUser_name() {
		return user_name;
	}
	public String getPassword() {
		return password;
	}
	public String getUsertype() {
		return usertype;
	}
	public String getSubscriptiontype() {
		return subscriptiontype;
	}
	public int getSubscription_id() {
		return subscription_id;
	}
	public int getDuespaid() {
		return duespaid;
	}
	public int getPending_dues() {
		return pending_dues;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public void setSubscriptiontype(String subscriptiontype) {
		this.subscriptiontype = subscriptiontype;
	}
	public void setSubscription_id(int subscription_id) {
		this.subscription_id = subscription_id;
	}
	public void setDuespaid(int duespaid) {
		this.duespaid = duespaid;
	}
	public void setPending_dues(int pending_dues) {
		this.pending_dues = pending_dues;
	}

}
