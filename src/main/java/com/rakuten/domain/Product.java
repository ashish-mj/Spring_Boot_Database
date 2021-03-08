package com.rakuten.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
private int productId;
private String productName;
private float price;
private List<Review> reviewList;

Product(){
}

Product(int id,String name,float price, List<Review> list){
	this.productId=id;
	this.productName=name;
	this.price=price;
	this.reviewList=list;
}

public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public List<Review> getReviewList() {
	return reviewList;
}
public void setReviewList(List<Review> reviewList) {
	this.reviewList = reviewList;
}


}