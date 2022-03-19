package com.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.lookify.models.Song;
import com.lookify.repositories.LookfyRepository;

@Service
public class LookfyService {
	private final LookfyRepository lookfyRepository;
	public LookfyService(LookfyRepository lookfyRepository) {
		this.lookfyRepository = lookfyRepository;
	}

	public List<Song> allSongs(){
		return lookfyRepository.findAll();
	}
	
	public Song createSong(Song song) {
		return lookfyRepository.save(song);
	}
	
	public Song findSong(Long id) {
		Optional<Song> optionalSong = lookfyRepository.findById(id);
		if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
	}
	
	public List<Song> containSongs(String txtsearch){
		return lookfyRepository.findByArtistContaining(txtsearch);
	}
	
	public List<Song> topSongs(Pageable pageable){
		return lookfyRepository.findByOrderByRatingDesc(PageRequest.of(0,10));
	}
	public void delete(Long id) {
		lookfyRepository.deleteById(id);
	}
	
}
