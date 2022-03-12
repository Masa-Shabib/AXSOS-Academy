package com.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloHuman {

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);

	}

	 @RequestMapping("/")
	 public String index(@RequestParam(value="q", required=false, defaultValue="Human") String name,
			 @RequestParam(value="q1", required=false, defaultValue="") String last_name,
			 @RequestParam(value="q2", required=false, defaultValue="1") String times) {
		 int times_int = Integer.parseInt(times);
		 String end="";
		 for (int i = 0; i < times_int; i++) {
	            end += "Hello " +name + " " + last_name + "\n";
	        }
			 return end;
		 
		
	       
	    }

}
