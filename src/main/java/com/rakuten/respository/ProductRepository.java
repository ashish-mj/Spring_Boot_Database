package com.rakuten.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rakuten.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
List<Product> findByProductName(String name);

}
