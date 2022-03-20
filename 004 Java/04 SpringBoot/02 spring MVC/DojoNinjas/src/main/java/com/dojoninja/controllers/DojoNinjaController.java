package com.dojoninja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojoninja.models.Dojo;
import com.dojoninja.models.Ninja;
import com.dojoninja.services.NinjaDojoService;

@Controller
public class DojoNinjaController {
	private final NinjaDojoService ninjaDojoService;

	public DojoNinjaController(NinjaDojoService ninjaDojoService) {
		this.ninjaDojoService = ninjaDojoService;
	}
	
	@GetMapping("/dojos")
	public String allDojos(Model model) {
		List<Dojo> item = ninjaDojoService.allDojos();
		model.addAttribute("dojos",item);
		return "alldojos.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String createDojo (@ModelAttribute("dojo") Dojo dojo) {
		return "newdojo.jsp";
	}
	
	@PostMapping("/dojos/new/add")
	public String addNewDojo (@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {	
			return "newdojo.jsp";
		}else {
			ninjaDojoService.createDojo(dojo);
			return "redirect:/dojos";
		}
	}
	@GetMapping("/ninjas/new")
	public String createNinja (@ModelAttribute("ninja") Ninja ninja,Model model) {
		List<Dojo> item = ninjaDojoService.allDojos();
		model.addAttribute("dojos",item);
		return "newninja.jsp";
	}
	
	@PostMapping("/ninjas/new/add")
	public String addNewNinja (@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result,Model model) {
		if (result.hasErrors()) {	
			List<Dojo> item = ninjaDojoService.allDojos();
			model.addAttribute("dojos",item);
			return "newninja.jsp";
		}else {
			ninjaDojoService.createNinja(ninja);
			return "redirect:/dojos";
		}
	}
	
	@GetMapping("/dojos/{id}")
	 public String show(@PathVariable("id") Long id, Model model) {
		Dojo dojo = ninjaDojoService.findDojo(id);
		model.addAttribute("dojo",dojo);
		List<Ninja> item = ninjaDojoService.dojoNinjas(dojo);
		model.addAttribute("ninjas",item);
		return "ninjadojo.jsp";
	}
}
