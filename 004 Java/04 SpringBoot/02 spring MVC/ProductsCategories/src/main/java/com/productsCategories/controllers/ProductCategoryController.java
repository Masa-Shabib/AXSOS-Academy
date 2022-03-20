package com.productsCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.productsCategories.modelles.Category;
import com.productsCategories.modelles.Product;
import com.productsCategories.services.ProductCategoryService;

@Controller
public class ProductCategoryController {
	private final ProductCategoryService productCategoryService;

	public ProductCategoryController(ProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}
	@GetMapping("/")
	public String allDojos(Model model) {
		List<Category> item = productCategoryService.allCategory();
		model.addAttribute("categories",item);
		return "main.jsp";
	}
	@GetMapping("/categories/new")
	public String newCategory (@ModelAttribute("category") Category category) {
		return "newCat.jsp";
	}
	
	@PostMapping("/categories/new")
	public String createCategory (@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {	
			return "newCat.jsp";
		}else {
			productCategoryService.createCategory(category);
			return "redirect:/";
		}
	}
	
	@GetMapping("/products/new")
	public String newProduct (@ModelAttribute("product") Product product) {
		return "newPro.jsp";
	}
	
	@PostMapping("/products/new")
	public String createProduct (@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {	
			return "newPro.jsp";
		}else {
			productCategoryService.createProduct(product);
			return "redirect:/";
		}
	}
	
	@GetMapping("/categories/{id}")
	 public String showCat(@PathVariable("id") Long id, Model model) {
		Category category = productCategoryService.findCategory(id);
		model.addAttribute("category",category);
		List<Product> item =productCategoryService.aveProduct(category);
		model.addAttribute("products",item);
		return "catDetail.jsp";
	}
	
	@GetMapping("/categories/{id}/relate")
	 public String relateCat(@PathVariable("id") Long id, Model model,@RequestParam("product") Long proId) {
		Category category = productCategoryService.findCategory(id);
		Product product =productCategoryService.findProduct(proId);
		productCategoryService.catProduct(category, product);
		return "redirect:/categories/"+id;
	}
	
	@GetMapping("/products/{id}")
	 public String showPro(@PathVariable("id") Long id, Model model) {
		Product product = productCategoryService.findProduct(id);
		model.addAttribute("product",product);
		List<Category> item =productCategoryService.aveCategory(product);
		model.addAttribute("categories",item);
		return "proDetail.jsp";
	}
	
	@GetMapping("/products/{id}/relate")
	 public String relatePro(@PathVariable("id") Long id, Model model,@RequestParam("category") Long catId) {
		Category category = productCategoryService.findCategory(catId);
		Product product =productCategoryService.findProduct(id);
		productCategoryService.productCat(category, product);
		return "redirect:/products/"+id;
	}
	
	
}
