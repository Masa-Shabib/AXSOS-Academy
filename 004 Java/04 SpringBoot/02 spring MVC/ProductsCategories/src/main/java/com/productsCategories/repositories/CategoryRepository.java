package com.productsCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.productsCategories.modelles.Category;
import com.productsCategories.modelles.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	List <Category> findByProductsNotContains(Product product);
}
