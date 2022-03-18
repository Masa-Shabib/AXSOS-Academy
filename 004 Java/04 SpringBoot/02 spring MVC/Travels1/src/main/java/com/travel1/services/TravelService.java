package com.travel1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.travel1.models.Expense;
import com.travel1.repositories.TravelRepo;

@Service
public class TravelService {
	private final TravelRepo travelRepository;

	public TravelService(TravelRepo travelRepository) {
		this.travelRepository = travelRepository;
	}
	
	// returns all the travels
    public List<Expense> allTravels() {
        return travelRepository.findAll();
    }
    // creates a travel
    public Expense createTravel(Expense t) {
        return travelRepository.save(t);
    }
    
    public Expense updateTravel(Expense t) {
    	Expense travel = travelRepository.findById(t.getId()).orElse(null);
    	assert travel!=null;
    	travel.setName(t.getName());
    	travel.setAmount(t.getAmount());
    	travel.setDescription(t.getDescription());
    	travel.setVendor(t.getVendor());
		return travelRepository.save(travel);
	}
    
    public Expense findTravel(Long id) {
        Optional<Expense> optionalTravel = travelRepository.findById(id);
        if(optionalTravel.isPresent()) {
            return optionalTravel.get();
        } else {
            return null;
        }
    }
    
    public void deleteTravel(Long id) {
		// TODO Auto-generated method stub
    	travelRepository.deleteById(id);
	}
}
