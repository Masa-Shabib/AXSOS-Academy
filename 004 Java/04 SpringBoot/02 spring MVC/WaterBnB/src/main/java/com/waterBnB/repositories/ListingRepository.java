package com.waterBnB.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.waterBnB.models.Listing;

@Repository
public interface ListingRepository extends CrudRepository<Listing, Long>{
	List <Listing> findAll();
	List<Listing> findByAddressContaining(String txtsearch);
}
