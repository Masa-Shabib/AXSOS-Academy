package com.bookClub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.bookClub.models.LoginUser;
import com.bookClub.models.User;
import com.bookClub.services.UserService;


@Controller
public class UserController {
    
    // Add once service is implemented:
    @Autowired
    private UserService userServ;
      
    @GetMapping("/")
    public String index(Model model) {
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }else {
        	User user1= userServ.register(newUser, result);
        	if(result.hasErrors()) {
                // Be sure to send in the empty LoginUser before 
                // re-rendering the page.
                model.addAttribute("newLogin", new LoginUser());
                return "index.jsp";}
        	else {
        		session.setAttribute("user", user1);
        		return "redirect:/books";
        	}
                
        }

    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }else {
        	User user1= userServ.login(newLogin, result);
        	if(result.hasErrors()) {
                // Be sure to send in the empty LoginUser before 
                // re-rendering the page.
        		model.addAttribute("newUser", new User());
                return "index.jsp";
                }
        	else {
        		session.setAttribute("user", user1);
        		return "redirect:/books";
        	}
                
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) { 
    		session.invalidate();
    		return "redirect:/";
    	
    }
    
    
}