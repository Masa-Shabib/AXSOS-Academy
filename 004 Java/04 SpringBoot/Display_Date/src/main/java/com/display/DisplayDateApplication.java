package com.display;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class DisplayDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayDateApplication.class, args);
	}
	@RequestMapping("/")
	public String main() {
		return ("main.jsp");
	}
	@RequestMapping("/date")
	public String date() {
		return ("date.jsp");
	}
	@RequestMapping("/time")
	public String time() {
		return ("time.jsp");
	}

}
