package com.mphasis.mySpring5BootApp.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

//@Component
//@Qualifier("smtpMail")
public class SmtpMailSender implements MailSender{

	private static Log log = LogFactory.getLog(SmtpMailSender.class);
	
	private JavaMailSender javaMailSender;
	
	public SmtpMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}


	@Override
	public void send(String to, String subject, String body) throws MessagingException {
//		log.info("Sending SMTP mail to : "+to);
//		log.info("with Subject : "+ subject);
//		log.info("Message : "+body);
		
		MimeMessage message = 	javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		
		helper = new MimeMessageHelper(message,true); //true indication -> multipart message
		
		helper.setSubject(subject);
		helper.setTo(to);
		helper.setText(body,true); // true indicates HTML
		
		//continue using helper for more functionalities
		//like adding attachments, etc.
		
		javaMailSender.send(message);
		
		
	}
	
}
