package com.rakuten.domain;



public class Review {
private int revId;
private String msg;
private float ratings;

public Review() {
	// TODO Auto-generated constructor stub
}

public Review(int revId, String msg, float ratings) {
	this.revId = revId;
	this.msg = msg;
	this.ratings = ratings;
}

public int getRevId() {
	return revId;
}
public void setRevId(int revId) {
	this.revId = revId;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public float getRatings() {
	return ratings;
}
public void setRatings(float ratings) {
	this.ratings = ratings;
}
}



