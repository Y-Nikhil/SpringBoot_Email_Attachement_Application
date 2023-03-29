package com.ashokit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.ashokit.service.EmailSenderService;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class SpringBootEmailAttachmentApplication {

	@Autowired
	private EmailSenderService emailSenderService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmailAttachmentApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerEmail()  throws MessagingException{
		emailSenderService.sendEmailWithAttachment("yarranikhil1@gmail.com", "Sending Mail", 
				"body","D:\\Files\\Resume\\Resume Nikhil.pdf");
	}
}
