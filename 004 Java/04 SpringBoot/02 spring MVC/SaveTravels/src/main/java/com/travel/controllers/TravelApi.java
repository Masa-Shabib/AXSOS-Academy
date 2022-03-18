package com.travel.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.models.Travel;
import com.travel.services.TravelService;

@RestController
public class TravelApi {
	private final TravelService travelService;

	public TravelApi(TravelService travelService) {
		this.travelService = travelService;
	}
	
	@RequestMapping("/api/travels")
    public List<Travel> index() {
        return travelService.allTravels();
    }
	@RequestMapping(value="/api/travels", method=RequestMethod.POST)
    public Travel create(@RequestParam(value="expense") String expense, @RequestParam(value="vendor") String vendor,@RequestParam(value="amount") Integer amount,
    		@RequestParam(value="amount") String desc) {
		Travel travel = new Travel(expense,vendor,amount,desc);
		return travelService.createTravel(travel);
    }
}
