package com.demo;

import java.util.*;

public class ProductStore {
	private String productStoreName;
	private List<Product> products;
	private List<String> branches;

	private Map<Integer, Supplier> suppliers;

	public void setSuppliers(Map<Integer, Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public void setBranches(List<String> branches) {
		this.branches = branches;
	}

	public void setProductStoreName(String productStoreName) {
		this.productStoreName = productStoreName;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void printDetails() {
		System.out.println("productStoreName: " + productStoreName);
		System.out.println("--------products in store -------------");
		products.forEach(p -> System.out.println(p));
		System.out.println("-------store branches-------------");

		branches.forEach(b -> System.out.println(b));

		System.out.println("-------store suppliers-------------");

		suppliers.forEach((id, supplier) -> System.out.println(id + ": " + supplier));
	}
}
