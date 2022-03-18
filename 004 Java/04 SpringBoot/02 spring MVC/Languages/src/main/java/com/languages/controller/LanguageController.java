package com.languages.controller;

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

import com.languages.models.Language;
import com.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	
	@GetMapping("/languages")
	public String main(Model model ,@ModelAttribute("language") Language language) {
        	List<Language> item = languageService.allLanguages();
            model.addAttribute("languages", item);
            return "main.jsp";

	}
	
	@PostMapping("/languages/create")
	public String create(Model model ,@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
        	List<Language> item = languageService.allLanguages();
            model.addAttribute("languages", item);
            return "main.jsp";
        } else {
        	languageService.createLanguage(language);
            return "redirect:/languages";
        }
	}
	
	@GetMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language item = languageService.findLanguage(id);
        model.addAttribute("languages", item);
		return "editform.jsp";
	}
	
	@PutMapping("/languages/{id}/edit/update")
	public String update(Model model ,@Valid @ModelAttribute("languages") Language language, BindingResult result) {
		if (result.hasErrors()) {
        	List<Language> item = languageService.allLanguages();
            model.addAttribute("languages", item);
            return "editform.jsp";
        } else {
        	languageService.updateLanguage(language);
            return "redirect:/languages";
        }
	}
	
	@GetMapping("/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
		Language item = languageService.findLanguage(id);
		model.addAttribute("languages", item);
        return "show.jsp";
    }
	
	@DeleteMapping("/languages/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
		languageService.delete(id);
        return "redirect:/languages";
    }
}
