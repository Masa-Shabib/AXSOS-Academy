package com.omikuji;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/omikuji")
@Controller
public class form {
	
	@RequestMapping("")	
	public String main() {
		return ("main.jsp");
	}
	
	@RequestMapping(value="/send", method=RequestMethod.POST)	
	public String send(HttpSession session,
			@RequestParam(value="counter") Integer counter,
			@RequestParam(value="city") String city,
			@RequestParam(value="name") String name,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="thing") String thing,
			@RequestParam(value="desc") String desc) {
		session.setAttribute("counter",counter);
		session.setAttribute("city",city);
		session.setAttribute("name",name);
		session.setAttribute("hobby",hobby);
		session.setAttribute("thing",thing);
		session.setAttribute("desc",desc);
		return ("redirect:/omikuji/show");
	}
	
	
	@RequestMapping("/show")	
	public String show(Model model, HttpSession session) {
		model.addAttribute("counter", (Integer) session.getAttribute("count"));
		model.addAttribute("city", (String) session.getAttribute("city"));
		model.addAttribute("name", (String) session.getAttribute("name"));
		model.addAttribute("hobby", (String) session.getAttribute("hobby"));
		model.addAttribute("thing", (String) session.getAttribute("thing"));
		model.addAttribute("desc", (String) session.getAttribute("desc"));
		return ("show.jsp");
	}
	
}
