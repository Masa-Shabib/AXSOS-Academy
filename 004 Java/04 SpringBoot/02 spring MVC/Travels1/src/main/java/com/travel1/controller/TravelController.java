package com.travel1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.travel1.models.Expense;
import com.travel1.services.TravelService;



@Controller
public class TravelController {
	
	private final TravelService travelService;
	public TravelController(TravelService travelService) {
		this.travelService = travelService;
	}
	
	@GetMapping("/travels")
    public String index(Model model,@ModelAttribute("travel") Expense travel) {
        List<Expense> item = travelService.allTravels();
        model.addAttribute("travels", item);
        return "main.jsp";
    }
	
	@PostMapping("/travels/create")
    public String create(@Valid @ModelAttribute("travel") Expense travel, BindingResult result,Model model) {
        if (result.hasErrors()) {
        	List<Expense> item = travelService.allTravels();
            model.addAttribute("travels", item);
            return "main.jsp";
        } else {
        	travelService.createTravel(travel);
            return "redirect:/travels";
        }
    }
	
	@GetMapping("/travels/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
		Expense item = travelService.findTravel(id);
		model.addAttribute("travels", item);
        return "editform.jsp";
    }
	
	@PutMapping("/travels/{id}/edit/update")
    public String update(@Valid @ModelAttribute("travels") Expense item, BindingResult result) {
        if (result.hasErrors()) {
            return "editform.jsp";
        } else {
        	travelService.updateTravel(item);
            return "redirect:/travels";
        }
    }
	@GetMapping("/travels/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
		Expense item = travelService.findTravel(id);
		model.addAttribute("travels", item);
        return "show.jsp";
    }
	
	@DeleteMapping("/travels/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
		travelService.deleteTravel(id);
        return "redirect:/travels";
    }
	
	
}
