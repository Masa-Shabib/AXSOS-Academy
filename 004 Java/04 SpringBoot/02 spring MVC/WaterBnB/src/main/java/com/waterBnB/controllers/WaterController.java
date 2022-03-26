package com.waterBnB.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.waterBnB.models.Listing;
import com.waterBnB.models.User;
import com.waterBnB.services.ListingService;
import com.waterBnB.services.ReviewService;

@Controller
public class WaterController {
	public final ListingService listingService;
	public final ReviewService reviewService;
	
	public WaterController(ListingService listingService, ReviewService reviewService) {
		this.listingService = listingService;
		this.reviewService = reviewService;
	}
	
	
	@GetMapping("/")
	public String landing() {
		return "Landing.jsp";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam(value="location") String searchQuery,Model model) {
		List <Listing> locationSearch= listingService.containAddress(searchQuery);
		model.addAttribute("locations",locationSearch); 
		return "Search.jsp";
	}
	
	@GetMapping("/host/dashboard")
	public String dashboard( @ModelAttribute("listing") Listing listing ,BindingResult result,Model model, HttpSession session) {
		if (session.getAttribute("user") != null) {
			User thisUser = (User) session.getAttribute("user");
			model.addAttribute("user", session.getAttribute("user")); 
			List <Listing>listings= thisUser.getOwnedListings();
			model.addAttribute("listings", listings); 
			return "Dashboard.jsp";
		} else {
			return "redirect:/guest/signin";
		}
		
	}
	
	@PostMapping("/host/dashboard")
	public String addListing(@Valid @ModelAttribute("listing") Listing listing ,BindingResult result,Model model, HttpSession session) {
		if (session.getAttribute("user") != null) {
			if (result.hasErrors()) {
				User thisUser = (User) session.getAttribute("user");
				model.addAttribute("user", session.getAttribute("user")); 
				return "Dashboard.jsp";
			}else {
				listingService.createListing(listing);
				return "redirect:/host/dashboard";
			} 
		}
		else {
			return "redirect:/guest/signin";
	}
	}
	
	
}
