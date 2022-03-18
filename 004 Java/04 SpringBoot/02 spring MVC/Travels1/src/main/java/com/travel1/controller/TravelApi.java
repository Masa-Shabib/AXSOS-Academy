package com.travel1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel1.models.Expense;
import com.travel1.services.TravelService;



@RestController
public class TravelApi {
	private final TravelService travelService;

	public TravelApi(TravelService travelService) {
		this.travelService = travelService;
	}
	
	@RequestMapping("/api/travels")
    public List<Expense> index() {
        return travelService.allTravels();
    }
	@RequestMapping(value="/api/travels", method=RequestMethod.POST)
    public Expense create(@RequestParam(value="name") String name, @RequestParam(value="vendor") String vendor,@RequestParam(value="amount") Integer amount,
    		@RequestParam(value="description") String description) {
		Expense travel = new Expense(name,vendor,amount,description);
		return travelService.createTravel(travel);
    }
}
