package com.bookClub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.bookClub.models.Book;
import com.bookClub.models.User;
import com.bookClub.services.BookService;




@Controller
public class BookController {
	@Autowired
    private BookService bookServ;
	
	@GetMapping("/books")
    public String home(Model model, HttpSession session) {
    	if (session.getAttribute("user") != null) {
    		model.addAttribute("user", session.getAttribute("user"));
    		List <Book> books = bookServ.allBooks();
    		model.addAttribute("books", books);
    		return "home.jsp";
    	}else {
    		return "redirect:/";
    	}
    }
	
	@GetMapping("/books/new")
	public String newBook (@ModelAttribute("book") Book book,Model model,HttpSession session) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			return "newBook.jsp";
    	}else {
    		return "redirect:/";
    	}
    }
	
	@PostMapping("/books/new")
	public String addNewBook (@Valid @ModelAttribute("book") Book book, BindingResult result,Model model,HttpSession session) {
		if (session.getAttribute("user") != null) {
			if (result.hasErrors()) {	
				model.addAttribute("user", session.getAttribute("user"));
				return "newBook.jsp";
			}else {
				bookServ.createBook(book);
				return "redirect:/books";
			}
    	}
		else {
    		return "redirect:/";
    	}
		
	}
	
	@GetMapping("/books/{id}")
	 public String show(@PathVariable("id") Long id, Model model,HttpSession session) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			Book book = bookServ.findBook(id);
			model.addAttribute("book",book);
			User user = (User) session.getAttribute("user");
			if(user.getId().equals(book.getUser().getId()) ) {
				session.setAttribute("edit", session.getAttribute("user"));
				model.addAttribute("L1", "You");
				model.addAttribute("L2", "your");
			}else {
				model.addAttribute("L1", book.getUser().getUserName());
				model.addAttribute("L2", book.getUser().getUserName()+"'s");
			}
			return "bookDetail.jsp";
    	}else {
    		return "redirect:/";
    	}	
	}
	
	@GetMapping("/books/{id}/edit")
	public String editBook (@PathVariable("id") Long id,Model model,HttpSession session) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user"));
			Book book = bookServ.findBook(id);
			model.addAttribute("book",book);
			return "editBook.jsp";
    	}else {
    		return "redirect:/";
    	}
    }
	@PutMapping("/books/{id}/edit")
	public String updateBook (@Valid @ModelAttribute("book") Book book, BindingResult result,@PathVariable("id") Long id,Model model,HttpSession session) {
		if (session.getAttribute("user") != null) {
			if (result.hasErrors()) {	
				model.addAttribute("user", session.getAttribute("user"));
				return "editBook.jsp";
			}else {
				bookServ.updateBook(book);
				return "redirect:/books/"+id;
			}
    	}
		else {
    		return "redirect:/";
    	}
    }
}
	
	

