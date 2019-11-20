package com.thp.spring.projetfinal.controller;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thp.spring.projetfinal.dto.ModeleDTO;
import com.thp.spring.projetfinal.dto.TacheModeleDTO;
import com.thp.spring.projetfinal.util.Categorie;
import com.thp.spring.projetfinal.util.Type;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ModeleControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@BeforeEach
	 protected void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
	   }
	
	@Test
	@WithMockUser(roles="COLLABORATEUR")
	void testAddModel() throws Exception {
		
		List<TacheModeleDTO> taskModels = new ArrayList<>();
		TacheModeleDTO tacheModeleDTO = new TacheModeleDTO("visa", Categorie.DOCUMENT);
		taskModels.add(tacheModeleDTO);
		this.mockMvc.perform(post("/model")

				.content(asJsonString(new ModeleDTO("test", "test", Type.COURT_SEJOUR, taskModels)))
		        .contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))

				.andExpect(status().isOk());
		
}


	@Test
	@WithMockUser(roles="COLLABORATEUR")
	void testFindAll() throws Exception {
		this.mockMvc.perform(get("/models")).andExpect(status().isOk());
	}

	@Test
	@WithMockUser(roles="COLLABORATEUR")
	void testGetModel() throws Exception {
		this.mockMvc.perform(get("/model?id=1")).andExpect(status().isOk());
	}

	@Test
	@WithMockUser(roles="COLLABORATEUR")
	void testUpdateModel() throws Exception {
		List<TacheModeleDTO> taskModels = new ArrayList<>();
		TacheModeleDTO tacheModeleDTO = new TacheModeleDTO("visa", Categorie.DOCUMENT);
		taskModels.add(tacheModeleDTO);
		ModeleDTO modeleDTO = new ModeleDTO(1L, "test2", "test", Type.COURT_SEJOUR, taskModels);
		this.mockMvc.perform(put("/model")

				.content(asJsonString(modeleDTO))
			        .contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))

					.andExpect(status().isOk());
	}
	

	@Test
	@WithMockUser(roles="COLLABORATEUR")
	void testDeleteModel() throws Exception {
		this.mockMvc.perform(delete("/model/1")).andExpect(status().isOk());
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
