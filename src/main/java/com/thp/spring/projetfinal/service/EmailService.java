package com.thp.spring.projetfinal.service;

import com.thp.spring.projetfinal.dto.MailDTO;

public interface EmailService {
	void sendEmail(MailDTO mail);
}
