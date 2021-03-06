package com.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.events.models.Event;
import com.events.models.Message;



@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{
	List <Message> findAll();
	List <Message> findByMessageEvent(Event event);
}
