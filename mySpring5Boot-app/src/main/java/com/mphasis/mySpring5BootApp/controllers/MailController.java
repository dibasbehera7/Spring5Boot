package com.mphasis.mySpring5BootApp.controllers;

import javax.mail.MessagingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mphasis.mySpring5BootApp.mail.MailSender;

@Controller
public class MailController {

//	private MailSender mailSender = new MockMailSender();
	
	private MailSender mailSender;
	
	//@Autowired
//	public MailController(@Qualifier("smtpMailSender") MailSender smtp) {
//		this.mailSender = smtp;
//	}
	public MailController(MailSender smtp) {
		this.mailSender = smtp;
	}

	@RequestMapping("/mail")
	public String mail() throws MessagingException {	
		
		mailSender.send("dibasinbox@gmail.com", "A Test Mail", "Hello, please check this out i completed my Spring 5 Boot Java Mail Sender Application.");
		
	return "Mail Sent";
	}
	
}
