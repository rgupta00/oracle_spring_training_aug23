package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.entities.Product;
import com.productapp.service.ProductService;
//Used to define rest end  points (API)

@RestController
public class ProductController{
	
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	//----get all products-----------
	@GetMapping(path = "products")
	public List<Product> getAll(){
		return productService.getAll();
	}

	//-----get an product by id
	//http://localhost:8090/products/2 --> to capture the variable part : @Pathvariable
	@GetMapping(path = "products/{id}")
	public Product getById( @PathVariable(name="id") int id) {
		return productService.getById(id);
	}
	
	//---add new product
	//ResponseEntity= data + http status code
	
	//@RequestBody will force json parser to convert json to java object
	@PostMapping(path = "products")
	public ResponseEntity<Product> addProduct(@RequestBody  Product product) {
		Product productAdded= productService.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(productAdded);
	}
	
	//---------update the existing product
	@PutMapping(path="products/{id}")
	public Product updateProduct(@PathVariable(name="id") int id, @RequestBody  Product product) {
		return productService.updateProduct(id, product);
	}

	//delete op status code 204
	
	//-----delete an existing product-------
	@DeleteMapping(path = "products/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable(name="id") int id) {
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}














