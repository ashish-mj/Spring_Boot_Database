package com.rakuten.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.domain.Product;
import com.rakuten.domain.ProductEntity;
import com.rakuten.domain.Review;
import com.rakuten.exceptions.ProductNotFoundException;
import com.rakuten.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService service;
	@RequestMapping("/test")
public String testRestApp() {
	return "<font color=blue size=10>Hello Client</font>";
}
@RequestMapping("/sample")
public Product sampleProduct() {
	Product p1=new Product();
	p1.setProductId(991);
	p1.setProductName("T Shirt");
	p1.setPrice(1000);
//	p1.setRatings(4.5f);
	return p1;
}
@RequestMapping(produces = {"application/xml","application/json"})
public ResponseEntity<ProductEntity> getAllProducts(){
	ProductEntity pe=new ProductEntity();
	
	pe.setList(service.getProducts());
	ResponseEntity<ProductEntity> re=new ResponseEntity<ProductEntity>(pe, HttpStatus.OK);
	return re;
}
@RequestMapping(value="/id/{pid}",produces = {"application/xml","application/json"})
public Product getProductById(@PathVariable int pid) {
	return service.searchByProductId(pid);
}
@RequestMapping(method = RequestMethod.POST,consumes= {"application/xml","application/json"},
produces = {"application/xml","application/json"})
public Product addProduct(@RequestBody Product p){
	return service.addNewProduct(p);
	
}

@RequestMapping(value="name/{name}",produces = {"application/xml","application/json"})
public ResponseEntity<ProductEntity> searchByProductName(@PathVariable String name){
	ProductEntity pe=new ProductEntity();
	
	pe.setList(service.searchByName(name));
	ResponseEntity<ProductEntity> re=new ResponseEntity<ProductEntity>(pe, HttpStatus.OK);
	return re;
}

@RequestMapping("/id/{pid}/reviews")
public List<Review> getReviewsForProduct(@PathVariable int pid) {
	List<Product> list=service.getProducts();
	Product product=list.stream().filter(p->p.getProductId()==pid).findFirst().get();
	return product.getReviewList();
}
@RequestMapping("/id/{pid}/reviews/review/{rid}")
public Review getReviewsById(@PathVariable int pid, @PathVariable("rid") int reviewId) {
	List<Product> list=service.getProducts();
	Product product=list.stream().filter(p->p.getProductId()==pid).findFirst().get();
	List<Review> reviews= product.getReviewList();
	Review review=reviews.stream().filter(r->r.getRevId()==reviewId).findFirst().get();
	return review;
}
}
