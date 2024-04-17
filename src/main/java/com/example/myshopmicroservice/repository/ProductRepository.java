package com.example.myshopmicroservice.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myshopmicroservice.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
	
	 @Query("SELECT p FROM Product p WHERE p.category = :category")
	    List<Product> findByCategory(@Param("category") String category);

}
