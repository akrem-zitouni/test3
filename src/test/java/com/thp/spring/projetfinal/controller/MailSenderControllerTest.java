package com.thp.spring.projetfinal.controller;


import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thp.spring.projetfinal.dto.MailDTO;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

class MailSenderControllerTest {

	ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	WebApplicationContext webApplicationContext;

	@BeforeEach
	protected void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
	}


	@WithMockUser(roles="COLLABORATEUR")
	@Test
	void evoyerEmailTest() throws Exception {

	MailDTO msg = new MailDTO();
	msg.setFrom("detachement@gmail.com");
	msg.setTo(new String[] {"hajer@talan.com"});

	msg.setSubject("test55");
	msg.setText("test55");
	System.out.println(msg);


	System.out.println(asJsonString(msg));

	this.mockMvc
	.perform(post("/mail").content(asJsonString(msg))
	.contentType(MediaType.APPLICATION_JSON))
	.andExpect(status().isOk());

	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
