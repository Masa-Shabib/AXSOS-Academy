package com.events.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.events.models.Event;
import com.events.models.User;
import com.events.repositories.EventRepository;



@Service
public class EventService {
	private final EventRepository eventRepository;

	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public List<Event> allEvents(){
		return eventRepository.findAll();
	}
	
	public Event findEventById(Long id) {
		Optional<Event> optionalEvent = eventRepository.findById(id);
        if(optionalEvent.isPresent()) {
            return optionalEvent.get();
        } else {
            return null;
        }
    }
	
	public List<Event> findEventsByState(String state){
		return eventRepository.findByState(state);
	}
	
	public List<Event> findEventsNotState(String state){
		return eventRepository.findByStateNot(state);
	}
	
	public Event creatEvent(Event event, BindingResult result) {
		LocalDate currentDate = LocalDate.now();
        if (event.getEventDate() == null) {
            result.rejectValue("eventDate", "Exist", "Please enter Event date");
            return null;}
        if ( event.getEventDate().isBefore(currentDate)) {
            result.rejectValue("eventDate", "Compare", "EventDate must be in the future ");
            return null;
        	}
        if(result.hasErrors()) {
            return null;
        }
            else {
        		return eventRepository.save(event);
        	}
	}
	
	public Event updateEvent(Event event, BindingResult result) {
        LocalDate currentDate = LocalDate.now();
        if (event.getEventDate() == null) {
            result.rejectValue("eventDate", "Exist", "Please enter a Date");
            return null;}
        System.out.println("service check");
        if (event.getEventDate().isBefore(currentDate)) {
            result.rejectValue("eventDate", "Compare", "Date mustb be in the future");
            return null;
        }
        if(result.hasErrors()) {
            return null;
        }
        Event editEvent = eventRepository.findById(event.getId()).orElse(null);
        assert editEvent!=null;
        editEvent.setName(event.getName());
        editEvent.setEventDate(event.getEventDate());
        editEvent.setLocation(event.getLocation());
        editEvent.setState(event.getState());
        return eventRepository.save(editEvent);
    }
	
	public Event joinEvent(Event event, User joinedUser) {
		event.getJoinedUsers().add(joinedUser);
		return eventRepository.save(event);
     }
	public Event cancelJoinEvent(Event event, User user) {
		event.getJoinedUsers().removeIf(item -> item.getId().equals(user.getId()));
      return eventRepository.save(event);
   }
	
	public void delete(Long id) {
		Event deleteEvent = eventRepository.findById(id).orElse(null); 
		eventRepository.delete(deleteEvent);
      }

	
}
