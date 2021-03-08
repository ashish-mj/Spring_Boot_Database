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
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping("/test")
	public String test() {
		return "Welcome Client";
	}
	
	@RequestMapping("/sample")
	public Product sample() {
		
		Product p=new Product();
		p.setProductId(1);
		p.setProductName("Phone");
		p.setPrice(10000f);
		return p;
		
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
		List<Product> list=service.getProducts();
		Optional<Product> optionalProduct=list.stream().filter(p->p.getProductId()==pid).findFirst();
		if(optionalProduct.isPresent())
			return optionalProduct.get();
		else
			throw new ProductNotFoundException("The product "+pid+" Not Found");
	}
	@RequestMapping(method = RequestMethod.POST,consumes= {"application/xml","application/json"},
	produces = {"application/xml","application/json"})
	public ResponseEntity<List<Product>> addProduct(@RequestBody Product p){
		List<Product> list=service.getProducts();
		list.add(p);
		ResponseEntity<List<Product>> entity=new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		return entity;
		
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
