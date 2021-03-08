package com.rakuten.exceptions;

public class ProductNotFoundException  extends RuntimeException{
	public ProductNotFoundException(){
		
	}
	public ProductNotFoundException(String s) {
		super(s);
	}
}

