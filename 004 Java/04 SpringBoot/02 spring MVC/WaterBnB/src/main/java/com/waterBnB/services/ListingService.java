package com.waterBnB.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.waterBnB.models.Listing;
import com.waterBnB.repositories.ListingRepository;

@Service
public class ListingService {
	public final ListingRepository listingRepostry;

	public ListingService(ListingRepository listingRepostry) {
		this.listingRepostry = listingRepostry;
	}
	
	public List<Listing> allListings(){
		return listingRepostry.findAll();
	}
	
	public List<Listing> containAddress(String txtsearch){
		return listingRepostry.findByAddressContaining(txtsearch);
	}
	
	public Listing findListingtById(Long id) {
		Optional<Listing> optionalListing = listingRepostry.findById(id);
        if(optionalListing.isPresent()) {
            return optionalListing.get();
        } else {
            return null;
        }
    }
	

	public Listing createListing (Listing listing) {
		return listingRepostry.save(listing);
	}
	
	public Listing updateListing (Listing listing) {
		Listing oldListing =listingRepostry.findById(listing.getId()).orElse(null);
		oldListing.setAddress(listing.getAddress());
		oldListing.setDescription(listing.getDescription());
		oldListing.setCost(listing.getCost());
		oldListing.setPoolSize(listing.getPoolSize());
		return listingRepostry.save(listing);
	}
	
//	private double calculateAverage(List <Integer> ratings) {
//			double sum = 0;
//		  if(!ratings.isEmpty()) {
//		    for (double rating : ratings) {
//		        sum += rating;
//		    }
//		    return sum / ratings.size();
//		  }
//		  return sum;
//		}
	
}
