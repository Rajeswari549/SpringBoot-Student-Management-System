package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.entity.Product;

@Repository
public interface InventoryRepository extends JpaRepository<Product, Integer> {    //product is cls name,a nd integer is generic type of cls (primary)
	
	

	
	
	
	

}
