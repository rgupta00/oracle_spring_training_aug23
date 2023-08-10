package com.productapp.service;

import java.util.List;

import com.productapp.entities.Product;
//service layer interface
public interface ProductService {
	//get all the products
	public List<Product> getAll();
	
	//get by id
	public Product getById(int id);
	
	//for adding the product
	public Product addProduct(Product product);
	
	//for updating the product
	public Product updateProduct(int id, Product product);
	
	//for deling the product
	public void deleteProduct(int id);
	
}
