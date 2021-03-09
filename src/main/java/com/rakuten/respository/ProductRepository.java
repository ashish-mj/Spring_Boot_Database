package com.rakuten.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.rakuten.domain.Product;
import com.rakuten.domain.Review;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
List<Product> findByProductName(String name);

@Modifying
@Query("update Review set msg=:reviewMsg where revId =:id")
int updateReview(@Param("id") int rid,@Param("reviewMsg") String msg);


}
