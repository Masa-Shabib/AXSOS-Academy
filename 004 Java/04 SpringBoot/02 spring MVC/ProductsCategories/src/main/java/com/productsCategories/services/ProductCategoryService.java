package com.productsCategories.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.productsCategories.modelles.Category;
import com.productsCategories.modelles.Product;
import com.productsCategories.repositories.CategoryRepository;
import com.productsCategories.repositories.ProductRepository;

@Service
public class ProductCategoryService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	public ProductCategoryService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Category> allCategory(){
		return categoryRepository.findAll();
	}
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }
	
	public List<Product> aveProduct(Category category){
		return productRepository.findByCategoriesNotContains(category);
	}
	
	public List<Category> aveCategory(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}
	
	public Category catProduct(Category category, Product product) {
		category.getProducts().add(product);
		return categoryRepository.save(category);
	}
	
	public Product productCat(Category category, Product product) {
		product.getCategories().add(category);
		return productRepository.save(product);
	}
	
	public void deletecat(Long id) {
		categoryRepository.deleteById(id);
	}
	
	
	
}
