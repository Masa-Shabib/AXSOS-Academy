package com.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.languages.models.Language;
import com.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	private final LanguageRepository languageRepository;

	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	
	public Language createLanguage(Language lang) {
		return languageRepository.save(lang);
	}
	
	public Language updateLanguage(Language lang) {
		Language lang1 =languageRepository.findById(lang.getId()).orElse(null);
		assert lang!=null;
		lang1.setName(lang.getName());
		lang1.setCreator(lang.getCreator());
		lang1.setVersion(lang.getVersion());
		return languageRepository.save(lang1);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLang = languageRepository.findById(id);
		if(optionalLang.isPresent()) {
            return optionalLang.get();
        } else {
            return null;
        }
	}
	
	public void delete(Long id) {
		languageRepository.deleteById(id);
	}
	
}
