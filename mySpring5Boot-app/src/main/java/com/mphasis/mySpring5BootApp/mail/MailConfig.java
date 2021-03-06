package com.mphasis.mySpring5BootApp.mail;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Configuration
//@Component
public class MailConfig {
	//@AutoWired
	//private JavaMailSender javaMailSender;
	
	@Bean
	public DemoBean demoBean() {
		return new DemoBean();
	}
	
	@Bean
	//@Profile("dev")
	@ConditionalOnProperty(name="spring.mail.host", havingValue="foo", matchIfMissing=true)
	public MailSender mockMailSender() {
		return new MockMailSender();
	}
	@Bean
	//@Profile("!dev")
	@ConditionalOnProperty("spring.mail.host")
	public MailSender smtpMailSender(JavaMailSender javaMailSender) {
		
		//can  call bean directly
		demoBean();
		
		return new SmtpMailSender(javaMailSender);
	}
	
}
