package com.events.controllers;

import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.events.models.Event;
import com.events.models.Message;
import com.events.models.User;
import com.events.services.EventService;
import com.events.services.MessagService;


@Controller
public class EventController {
	
	private final EventService eventService;
	private final MessagService messageService;
	
	

	public EventController(EventService eventService, MessagService messageService) {
		this.eventService = eventService;
		this.messageService = messageService;
	}

	@RequestMapping("/events")
	public String main(@ModelAttribute("event") Event event ,BindingResult result,Model model, HttpSession session) {
		if (session.getAttribute("user") != null) {
			User thisUser = (User) session.getAttribute("user");
			model.addAttribute("user", session.getAttribute("user")); 
			List<Event> inStateEvents = eventService.findEventsByState(thisUser.getState());
			model.addAttribute("inStateEvents", inStateEvents);
			List<Event> outStateEvents = eventService.findEventsNotState(thisUser.getState());
			model.addAttribute("outStateEvents", outStateEvents);
			return "Main.jsp";
		} else {
			return "redirect:/";
		}
	}
	
	@PostMapping("/events/create")
	public String newEvent(Model model, HttpSession session,@Valid @ModelAttribute("event") Event event,BindingResult result ) {
		if (session.getAttribute("user") != null) {
			eventService.creatEvent(event, result);
			if (result.hasErrors()) {
				User thisUser = (User) session.getAttribute("user");
				model.addAttribute("user", session.getAttribute("user")); 
				List<Event> inStateEvents = eventService.findEventsByState(thisUser.getState());
				model.addAttribute("inStateEvents", inStateEvents);
				List<Event> outStateEvents = eventService.findEventsNotState(thisUser.getState());
				model.addAttribute("outStateEvents", outStateEvents);
				return "Main.jsp";
			}else {
				return "redirect:/events";
			}
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping("/events/{eventId}/join")
	public String joinEvent(@PathVariable("eventId")Long id,Model model, HttpSession session) {
		if (session.getAttribute("user") != null) {
			User thisUser = (User) session.getAttribute("user");
			Event thisEvent = eventService.findEventById(id);
			eventService.joinEvent(thisEvent, thisUser);
			return "redirect:/events";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping("/events/{eventId}/cancel")
	public String notJoinEvent(@PathVariable("eventId")Long id,Model model, HttpSession session) {
		if (session.getAttribute("user") != null) {
			User thisUser = (User) session.getAttribute("user");
			Event thisEvent = eventService.findEventById(id);
			eventService.cancelJoinEvent(thisEvent, thisUser);
			return "redirect:/events";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping("/events/{eventId}/delete")
	public String deleteEvent(@PathVariable("eventId")Long id,Model model, HttpSession session) {
		if (session.getAttribute("user") != null) {
			eventService.delete(id);
			return "redirect:/events";
		} else {
			return "redirect:/";
		}
	}
	
	@GetMapping("/events/{eventId}/edit")
    public String editEvent(@PathVariable("eventId") Long id, HttpSession session, Model model) {
        if (session.getAttribute("user") != null) {
            model.addAttribute("user", session.getAttribute("user"));
            Event event = eventService.findEventById(id);
            model.addAttribute("myEvent",event);
            return "EditEvent.jsp";
        }else {
            return "redirect:/";
        }
    }
	@PutMapping("/events/{eventId}/edit")
    public String updateEvent (@PathVariable("eventId") Long id, @Valid @ModelAttribute("myEvent") Event myEvent, BindingResult result,HttpSession session, Model model) {
        if (session.getAttribute("user") != null) {
            model.addAttribute("user", session.getAttribute("user"));
            System.out.println("before has errors");
            eventService.updateEvent(myEvent, result);
            if (result.hasErrors()) {
                System.out.println("after has errors");
                model.addAttribute("user", session.getAttribute("user"));
                Event thisEvent = eventService.findEventById(id);
                model.addAttribute("event",thisEvent);
                return "EditEvent.jsp";
            }else {
                return "redirect:/events";
            }
        }else {
            return "redirect:/";
        }
    }
	
	@RequestMapping("/events/{eventId}")
	public String showEvent(@PathVariable("eventId")Long id,Model model, HttpSession session,@ModelAttribute("message") Message message) {
		if (session.getAttribute("user") != null) {
			model.addAttribute("user", session.getAttribute("user")); 
			Event thisEvent = eventService.findEventById(id);
			model.addAttribute("event",thisEvent);
			List <User> atendee = thisEvent.getJoinedUsers();
			model.addAttribute("atendee", atendee);
			List <Message> eventmessages = thisEvent.getEventMessages();
			model.addAttribute("eventmessages",eventmessages);
			return "ShowEvent.jsp";
		} else {
			return "redirect:/";
		}
	}
	
	@PostMapping("/events/{eventId}/add")
	public String addMessage(@PathVariable("eventId")Long id,Model model, HttpSession session,@Valid @ModelAttribute("message") Message message, BindingResult result) {
		if (session.getAttribute("user") != null) {
			if (result.hasErrors()) {
				model.addAttribute("user", session.getAttribute("user")); 
				Event thisEvent = eventService.findEventById(id);
				model.addAttribute("event",thisEvent);
				List <User> atendee = thisEvent.getJoinedUsers();
				model.addAttribute("atendee", atendee);
				List <Message> eventmessages = thisEvent.getEventMessages();
				model.addAttribute("eventmessages",eventmessages);
				return "ShowEvent.jsp";
            }else {
            	messageService.creatMessage(message);
                return "redirect:/events/"+ id ;
            }
			
		} else {
			return "redirect:/";
		}
	}
}
