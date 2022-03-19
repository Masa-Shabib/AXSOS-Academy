package com.lookify.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lookify.models.Song;
import com.lookify.services.LookfyService;

@Controller
public class LookfyController {
	private final LookfyService lookfyService;

	public LookfyController(LookfyService lookfyService) {
		this.lookfyService = lookfyService;
	}
	
	@GetMapping("/")
	public String dash() {
		return "dash.jsp";
	}
	
	@GetMapping("/dashboard")
	public String main(Model model ,@ModelAttribute("song") Song song) {
		List<Song> item = lookfyService.allSongs();
		model.addAttribute("songs",item);
		return "main.jsp";
	}
	
	@GetMapping("/songs/new")
	public String create (@ModelAttribute("song") Song song) {
		return "addform.jsp";
	}
	
	@PostMapping("/songs/new/add")
	public String addNew (@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {	
			return "addform.jsp";
		}else {
			lookfyService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/songs/{id}")
	 public String show(@PathVariable("id") Long id, Model model) {
		Song item = lookfyService.findSong(id);
		model.addAttribute("song",item);
		return "show.jsp";
	}
	@GetMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> item=lookfyService.topSongs(PageRequest.of(0,10));
		model.addAttribute("songs",item);
		return "topten.jsp";
	}
	@GetMapping("/search")
	public String search(@RequestParam("txtsearch") String txtsearch1) {
		return "redirect:/search/"+txtsearch1;
	}
	@GetMapping("/search/{txtsearch1}")
	public String searching(@PathVariable("txtsearch1") String txtsearch, Model model) {
		model.addAttribute("key",txtsearch);
		List<Song> item=lookfyService.containSongs(txtsearch);
		model.addAttribute("songs",item);
		return "search.jsp";
	}
	@DeleteMapping("/songs/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
		lookfyService.delete(id);
        return "redirect:/dashboard";
    }
	
}
