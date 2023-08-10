package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.entities.Product;
import com.productapp.exceptions.ProductNotFundException;
import com.productapp.repo.ProductRepo;

@Service
@Transactional //ACID
public class ProductServiceImpl implements ProductService{

	private ProductRepo productRepo;
	
	@Autowired
	public ProductServiceImpl(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public List<Product> getAll() {
		return productRepo.findAll();
	}

	@Override
	public Product getById(int id) {
		//java 8 stream programming
		return productRepo.findById(id)
				.orElseThrow(()->new ProductNotFundException("product not found id: "+id));
	}

	@Override
	public Product addProduct(Product product) {
		productRepo.save(product);
		return product;
	}

	@Override
	public Product updateProduct(int id, Product product) {
		Product productToUpdate=getById(id);
		productToUpdate.setPrice(product.getPrice());
		productRepo.save(productToUpdate);//same method wether to save or update the records
		
		return productToUpdate;
	}

	@Override
	public void deleteProduct(int id) {
		Product productToDelete= getById(id);
		productRepo.delete(productToDelete);
		
	}
}






