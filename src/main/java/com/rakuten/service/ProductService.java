package com.rakuten.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.domain.Product;
import com.rakuten.exceptions.ProductNotFoundException;
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

public Product searchByProductId(int pid) {
	Optional<Product> optionalProduct= productRepository.findById(pid);
	if(optionalProduct.isPresent())
		return optionalProduct.get();
	throw new ProductNotFoundException("The product id "+pid+" u r searching is not avilable");
}

public List<Product> searchByName(String n){
	return productRepository.findByProductName(n);
}

}