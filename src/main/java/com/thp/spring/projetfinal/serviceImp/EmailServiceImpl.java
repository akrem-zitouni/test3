package com.thp.spring.projetfinal.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.thp.spring.projetfinal.dto.MailDTO;
import com.thp.spring.projetfinal.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	public JavaMailSender javaMailSender;

	/*
	 * This JavaMailSender Interface is used to send Mail in Spring Boot. This
	 * JavaMailSender extends the MailSender Interface which contains send()
	 * function. SimpleMailMessage Object is required because send() function uses
	 * object of SimpleMailMessage as a Parameter
	 */
	public void sendEmail(MailDTO mail) {
		javaMailSender.send(mail);
	}

}

