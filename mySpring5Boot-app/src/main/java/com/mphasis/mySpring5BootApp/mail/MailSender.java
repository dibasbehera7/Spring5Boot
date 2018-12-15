package com.mphasis.mySpring5BootApp.mail;

import javax.mail.MessagingException;

public interface MailSender {

	void send(String to, String subject, String body) throws MessagingException;
	
}
