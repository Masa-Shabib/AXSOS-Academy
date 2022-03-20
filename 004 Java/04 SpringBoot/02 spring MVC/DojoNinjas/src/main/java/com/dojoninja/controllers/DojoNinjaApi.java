package com.dojoninja.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dojoninja.models.Dojo;
import com.dojoninja.services.NinjaDojoService;

@RestController
public class DojoNinjaApi {
	private final NinjaDojoService ninjaDojoService;

	public DojoNinjaApi(NinjaDojoService ninjaDojoService) {;
		this.ninjaDojoService = ninjaDojoService;
	}
	
	@RequestMapping("/api/dojos")
	public List<Dojo>allDojos(){
		return ninjaDojoService.allDojos();
	}
	
	@RequestMapping(value="/api/dojos", method=RequestMethod.POST)
	public Dojo create(@RequestParam(value="name") String name) {
		Dojo dojo = new Dojo(name);
		return ninjaDojoService.createDojo(dojo);
	}
	
}
