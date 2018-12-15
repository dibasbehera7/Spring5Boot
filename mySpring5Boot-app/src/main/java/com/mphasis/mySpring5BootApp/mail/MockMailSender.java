package com.mphasis.mySpring5BootApp.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
////@Primary
public class MockMailSender implements MailSender{

	private static Log log = LogFactory.getLog(MockMailSender.class);
	
	@Override
	public void send(String to, String subject, String body) {
		log.info("Sending Mock mail to : "+to);
		log.info("with Subject : "+ subject);
		log.info("Message : "+body);
		
	}
	
}
