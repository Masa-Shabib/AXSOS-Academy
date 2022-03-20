package com.productsCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.productsCategories.modelles.Category;
import com.productsCategories.modelles.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	List <Product> findAll();
	List <Product> findByCategoriesNotContains(Category category);
}
