package com.lookify.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lookify.models.Song;
import com.lookify.services.LookfyService;

@RestController
public class LookfyApi {
	private final LookfyService lookfyService;
	public LookfyApi(LookfyService lookfyService) {
		this.lookfyService = lookfyService;
	}
	
	@RequestMapping("/api/songs")
	public List<Song> allSongs(){
		return lookfyService.allSongs();
	}
	
	@RequestMapping(value="/api/songs", method=RequestMethod.POST)
	public Song create(@RequestParam(value="name") String name, @RequestParam(value="artist") String artist,@RequestParam(value="rating") Integer rating) {
		Song song= new Song(name,artist,rating);
		return lookfyService.createSong(song);
	}
	
	
}
