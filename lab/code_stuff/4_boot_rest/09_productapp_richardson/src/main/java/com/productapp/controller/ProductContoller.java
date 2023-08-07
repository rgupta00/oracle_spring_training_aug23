package com.productapp.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dto.ProductDto;
import com.productapp.entity.Product;
import com.productapp.service.ProductService;

@RestController
@RequestMapping(path = "api")
public class ProductContoller {

	private ProductService productService;

	@Autowired
	public ProductContoller(ProductService productService) {
		this.productService = productService;
	}

	// ResponseEntity= Data + status code

	// --------get all products-----------
	@GetMapping(path = "products")
	public ResponseEntity<List<Product>> getAll() {
		return ResponseEntity.ok(productService.getAll());
	}

	// --------get one product-----------
	@GetMapping(path = "products/{id}")
	public ResponseEntity<Product> getAnProductById(@PathVariable(name = "id") int id) {
		return ResponseEntity.ok(productService.getById(id));
	}

	//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
	//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

	@GetMapping(path = "products-v2")
	public CollectionModel<ProductDto> getAllHatoes() {
		List<Product> productList = productService.getAll();

		List<ProductDto> productDtoList = productList.stream().map(this::convertToProductDto).toList();

		for (ProductDto dto : productDtoList) {
			Link link = linkTo(methodOn(ProductContoller.class).getAnProductByIdHatoes(dto.getId())).withSelfRel();
			dto.add(link);
		}
		return CollectionModel.of(productDtoList);
	}

	@GetMapping(path = "products-v2/{id}")
	public EntityModel<ProductDto> getAnProductByIdHatoes(@PathVariable(name = "id") int id) {
		
		Link link = linkTo(methodOn(ProductContoller.class).getAnProductByIdHatoes(id)).withSelfRel();
		Product product = productService.getById(id);
		ProductDto dto = new ProductDto();
		dto.setName(product.getName());
		dto.setId(product.getId());
		dto.setPrice(product.getPrice());

		dto.add(link);
		return EntityModel.of(dto);

	}

	// -------add one product-----------
	@PostMapping(path = "products")
	public ResponseEntity<Product> addAnProduct(@Valid @RequestBody ProductDto productDto) {
		Product product = convertToProduct(productDto);

		Product productSaved = productService.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
	}

	private Product convertToProduct(ProductDto productDto) {
		Product product = new Product();
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		return product;
	}

	private ProductDto convertToProductDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		return productDto;
	}
	
	
	// --------updated an product---------
	@PutMapping(path = "products/{id}")
	public ResponseEntity<Product> updateAnProduct(@PathVariable(name = "id") int id,
			@RequestBody Product product) {
		Product updatedProduct = productService.updateProduct(id, product);
		return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
	}

	@DeleteMapping(path = "products/{id}")
	public ResponseEntity<Void> deleteAnProduct(@PathVariable(name = "id") int id) {
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
