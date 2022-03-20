package com.productsCategories.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.productsCategories.modelles.Category;
import com.productsCategories.modelles.Product;
import com.productsCategories.services.ProductCategoryService;

@RestController
public class ProductCategoryApi {
	private final ProductCategoryService productCategoryService;

	public ProductCategoryApi(ProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}
	
	@RequestMapping("/api/products")
	public List<Product> allProducts(){
		return productCategoryService.allProducts();
	}
	
	@RequestMapping(value="/api/products", method=RequestMethod.POST)
	public Product createProduct(Product product) {
		return productCategoryService.createProduct(product);
	}
	
	@RequestMapping("/api/categories")
	public List<Category> allCategory(){
		return productCategoryService.allCategory();
	}
	
	@RequestMapping(value="/api/categories", method=RequestMethod.POST)
	public Category createCategory(Category category) {
		return productCategoryService.createCategory(category);
	}
	
	@RequestMapping(value="/api/categories/{id}", method=RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) {
		productCategoryService.deletecat(id);
    }
	
}
