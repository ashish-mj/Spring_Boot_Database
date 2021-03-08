package com.rakuten.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.domain.Product;
import com.rakuten.respository.ProductRepository;

@Service
public class ProductService {
	@Autowired
private ProductRepository productRepository;
public List<Product> getProducts() {
	List<Product> productList=new ArrayList<Product>();
	productRepository.findAll().forEach(p->productList.add(p));
	return productList;
}
public Product addNewProduct(Product p) {
	Product savedProduct=productRepository.save(p);
	return savedProduct;
}
}