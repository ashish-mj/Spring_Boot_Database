package com.rakuten.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class Product {
@Id
private int productId;
private String productName;
private float price;

@OneToMany(mappedBy="product", cascade = CascadeType.ALL)
private List<Review> reviewList;

public Product(){
}

public Product(int id,String name,float price, List<Review> list){
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