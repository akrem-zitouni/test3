
package com.thp.spring.projetfinal.controller;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thp.spring.projetfinal.dto.RoleDTO;
import com.thp.spring.projetfinal.dto.UtilisateurDTO;
import com.thp.spring.projetfinal.service.UtilisateurService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class UtilisateurControllerTest {
	@MockBean
	private UtilisateurService utilisateurService;
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
	void testAddUtilisateur() throws Exception{
	
			this.mockMvc.perform(post("/utilisateur")

					.content(asJsonString(new UtilisateurDTO("test12", "test12", "test12")))
			        .contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))

					.andExpect(status().isOk());
			
	}

	@WithMockUser(roles="COLLABORATEUR")
	@Test
	void testFindAllUser() throws Exception {
		this.mockMvc.perform(get("/utilisateurs")).andExpect(status().isOk());
	}
	
	@WithMockUser(roles="COLLABORATEUR")
	@Test
	void testGetUser() throws Exception {
		this.mockMvc.perform(get("/utilisateur?id=1")).andExpect(status().isOk());
	}

	@WithMockUser(roles="COLLABORATEUR")
	@Test
	void testGetUserByPseudo() throws Exception {
		this.mockMvc.perform(get("/parPseudo/moez")).andExpect(status().isOk());	
	}

	@WithMockUser(roles="COLLABORATEUR")
	@Test
	void testUpdateUser() throws Exception {
	RoleDTO role = new RoleDTO();
		role.setId(1L);
 UtilisateurDTO manager=new UtilisateurDTO();
		List<UtilisateurDTO> collaborateurs;
	UtilisateurDTO utilisateurDTO = new UtilisateurDTO(1L,"gafsa", "tunis", "tunis");
		this.mockMvc.perform(put("/utilisateur")

				.content(asJsonString(utilisateurDTO))
			        .contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))

					.andExpect(status().isOk());
	}

	@WithMockUser(roles="COLLABORATEUR")
	@Test
	void testDeleteUser() throws Exception {
		this.mockMvc.perform(delete("/utilisateur/1")).andExpect(status().isOk());
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

