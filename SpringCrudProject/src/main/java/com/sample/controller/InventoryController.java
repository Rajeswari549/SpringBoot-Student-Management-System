package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.entity.Product;
import com.sample.service.InventoryService;

@RestController
@RequestMapping("/app")                         //whch is used for identification of application   -->this is main url
public class InventoryController {
	
	
//	/controller needs service dependency
	@Autowired
	private InventoryService service;

	
//	*****************1.webservice for insert***********************8
	@PostMapping("/insert")                     //this is suburl
	public  ResponseEntity<Product>  saveData( @RequestBody Product p)         //requestbody is used for requesting body for postman
	{
		
		Product p1 = service.saveData(p);
		return ResponseEntity.ok(p1);
	}
	
	
//		***********************2.webservice to read the data********************

	@GetMapping("/readall")         //suburl
	public List<Product> readAllProducts()
	{
		List<Product> allProducts = service.readAllProducts();
		return allProducts;
		
	}
	
	
	
//	****************************read one data*********************
	@GetMapping("readonedata/{pno}")
	public void readoneProduct(@PathVariable int  pno)
	{
		
		service.readonedata(pno);
	}
	
	
//	***********************3.webservice to dlete the product***********
	@DeleteMapping("/delete/{pno}")
	public void deleteProduct(@PathVariable int  pno)
	{
		service.deleteProduct(pno);
	}
	
	
//		***********************3.webservice to update the product***********
	
	@PutMapping("/update/{pno}")
	public Product updateProduct(@PathVariable int pno, @RequestBody Product np)
	{
		Product updateProduct = service.updateProduct(pno, np);
		return updateProduct;
		
		
		
	}
	
			

}
