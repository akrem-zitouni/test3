package com.thp.spring.projetfinal.serviceImp;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import com.thp.spring.projetfinal.dto.MailDTO;
import com.thp.spring.projetfinal.service.EmailService;
@Transactional
@Rollback(true)
@SpringBootTest
@ActiveProfiles("test")
class EmailServiceImlpTest {

	@Autowired
	EmailService emailService;
	@Test
	void testSendEmail() {

	MailDTO mail=new MailDTO("byblos@talan.com",new String[] {"hajer@talan.com","hajer@talan.com"},"test","text");
	emailService.sendEmail(mail);
	assertEquals(mail.getSubject(),"test");

	}

}
