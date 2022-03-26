package com.events.services;


import org.springframework.stereotype.Service;

import com.events.models.Message;
import com.events.repositories.MessageRepository;

@Service
public class MessagService {

	private final MessageRepository messageRepository;
	
	
	public MessagService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}


	public Message creatMessage(Message message) {
		return messageRepository.save(message);
	}
}
