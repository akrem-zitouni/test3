package com.thp.spring.projetfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thp.spring.projetfinal.dto.MailDTO;
import com.thp.spring.projetfinal.service.EmailService;

@RestController
@CrossOrigin("*")
public class EmailController {

	@Autowired
	EmailService emailService;

	/* envoyer un email */

	@PostMapping(value = "/mail")
	public void evoyerEmail(@RequestBody MailDTO mailMessage) {

		MailDTO mMessage = new MailDTO();

		mMessage.setTo(mailMessage.getTo());

		mMessage.setSubject(mailMessage.getSubject());

		mMessage.setText(mailMessage.getText());
		emailService.sendEmail(mMessage);
	}

}
