package com.sample.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int pid;
	private String pname;
	private int pquantity;
	private int pprice;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String pname, int pquantity, int pprice) {
		super();
		this.pname = pname;
		this.pquantity = pquantity;
		this.pprice = pprice;
	}
	
	
	

}
