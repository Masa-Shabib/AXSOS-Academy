package com.dojoninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojoninja.models.Dojo;
import com.dojoninja.models.Ninja;
import com.dojoninja.repositories.DojoRepository;
import com.dojoninja.repositories.NinjaRepository;

@Service
public class NinjaDojoService {
	private final DojoRepository dojoRepository;
	private final NinjaRepository ninjaRepository;
	public NinjaDojoService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Dojo>allDojos(){
		return dojoRepository.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	public List<Ninja>allNinjas(){
		return ninjaRepository.findAll();
	}
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
	
	public List<Ninja> dojoNinjas(Dojo dojo){
		return ninjaRepository.findByDojo(dojo);
	}
}

