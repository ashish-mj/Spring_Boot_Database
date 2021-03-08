package com.rakuten.domain;

import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class ProductEntity {
	List<Product> list=new ArrayList<Product>();

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}
	
}

