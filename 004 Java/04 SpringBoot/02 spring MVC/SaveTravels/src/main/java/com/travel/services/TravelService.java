package com.travel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travel.models.Travel;
import com.travel.repositories.TravelRepository;

@Service
public class TravelService {
	private final TravelRepository travelRepository;

	public TravelService(TravelRepository travelRepository) {
		this.travelRepository = travelRepository;
	}
	
	// returns all the travels
    public List<Travel> allTravels() {
        return travelRepository.findAll();
    }
    // creates a travel
    public Travel createTravel(Travel t) {
        return travelRepository.save(t);
    }
	
}
