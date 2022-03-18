package com.travel1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.travel1.models.Expense;




@Repository
public interface TravelRepo extends CrudRepository<Expense, Long>{
	List<Expense> findAll();
}
