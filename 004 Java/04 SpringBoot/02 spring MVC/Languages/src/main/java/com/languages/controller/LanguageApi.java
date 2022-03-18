package com.languages.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.languages.models.Language;
import com.languages.services.LanguageService;

@RestController
public class LanguageApi {
	private final LanguageService languageService;

	public LanguageApi(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/api/languages")
	public List<Language> allLanguages(){
		return languageService.allLanguages();
	}
	
	@RequestMapping(value="/api/languages", method=RequestMethod.POST)
    public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator,@RequestParam(value="version") String version) {
		Language lang = new Language(name,creator,version);
		return languageService.createLanguage(lang);
	}
	
}
