package com.lookify.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lookify.models.Song;

@Repository
public interface LookfyRepository extends CrudRepository<Song,Long> {
	List<Song> findAll();
	
	List<Song> findByOrderByRatingDesc(Pageable pageable);
	
	List<Song> findByArtistContaining(String txtsearch);
}
