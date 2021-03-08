package com.rakuten.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

//import javax.xml.bind.annotation.XmlRootElement;

@Service
public class ProductService {
private List<Product> product=new ArrayList<Product>();
{
	List<Review> rev1=new ArrayList<Review>();
	Review r1=new Review(991,"Good Product",4.5f);
	Review r2=new Review(992,"Not Good Product",3.5f);
	Review r3=new Review(993,"ok ok Product",4f);
	rev1.add(r1);rev1.add(r2);rev1.add(r3);
	
	List<Review> rev2=new ArrayList<Review>();
	Review r4=new Review(994,"Average",3.5f);
	Review r5=new Review(995,"Best Product",4.5f);
	Review r6=new Review(996,"Worst Product",3.2f);
	rev2.add(r4);rev2.add(r5);rev2.add(r6);
	
	Product p1=new Product(111, "Fast Track Watch", 2000,rev1);
	
	Product p2=new Product(112, "one plus mobile", 25000,rev2);
	Product p3=new Product(113, "T Shirt", 1500,rev1);
	Product p4=new Product(114, "Trimmer", 1000,rev2);
	Product p5=new Product(115, "Head phones", 2500,rev1);
	product.add(p1);
	product.add(p2);
	product.add(p3);
	product.add(p4);
	product.add(p5);
	
}

public List <Product> getProducts(){
  return this.product;
}
}