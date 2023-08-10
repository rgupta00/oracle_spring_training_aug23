package com.productapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productapp.entities.Product;
//it will provide u all the crud method without doing any coding :)
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
