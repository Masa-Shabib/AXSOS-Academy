package com.dojoninja.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojoninja.models.Dojo;
import com.dojoninja.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	List <Ninja> findAll();
	List <Ninja> findByDojo(Dojo dojo);
}
