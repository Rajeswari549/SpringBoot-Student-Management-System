package com.sample.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Product;
import com.sample.repository.InventoryRepository;

import jakarta.persistence.Entity;

@Service
public class InventoryService {
	
	//service layer needs repository object
	//add repository dependency
	
	@Autowired                                                    //this annotation is used to inject dependecny in springboot
	 private   InventoryRepository repository;
	
	
	
//	method to insert the data
	public  Product  saveData(Product p)                    //it conatins all the information of product
	{
		Product p1 = repository.save(p);
		return p1;	
	}
	
//	method to read the data
	public List<Product> readAllProducts()
	{
		
		List<Product> all = repository.findAll();
		return all;
		
	}
	
//	method to delete the data
	public void deleteProduct(int id)
	{
		repository.deleteById(id);
		
	}

	
//	method to read one data
	
	public Optional<Product> readonedata(int id)
	{
		Optional<Product> byId = repository.findById(id);
		return byId;
	}
	
//	public Product readonedata(int id) {
//	    return repository.findById(id)
//	            .orElseThrow(() -> new RuntimeException("not found!"));
//	}

	
	
//	method to update the data
	
	public Product updateProduct(int id,Product np)
	{
		
		Optional<Product> temp = repository.findById(id);
		if(temp.isPresent())	
		{
			Product oldproduct = temp.get();
			oldproduct.setPname(np.getPname());     //frm new pro we get the old product
			oldproduct.setPprice(np.getPprice());
			oldproduct.setPquantity(np.getPquantity());
			 return repository.save(oldproduct);                //here we need to save the all data after updating 
		}
		else
		{
			 throw new RuntimeException("Product not found!");
		}
		
	}
}
