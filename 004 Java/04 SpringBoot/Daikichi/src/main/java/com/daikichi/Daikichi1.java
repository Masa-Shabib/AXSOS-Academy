package com.daikichi;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/daikichi")
public class Daikichi1 {
	@RequestMapping("")
	public String welcome() {
		return("Welcome");
	}
	@RequestMapping("/today")
	public String today() {
		return("Today you will find luck in all your endeavors!");
	}
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return("Tomorrow, an opportunity will arise, so be sure to be open to new ideas!");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DaikichiApplication.class, args);
	}
}
