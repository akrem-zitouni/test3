
package com.thp.spring.projetfinal.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.thp.spring.projetfinal.dto.MissionDTO;
import com.thp.spring.projetfinal.dto.ModeleDTO;
import com.thp.spring.projetfinal.dto.TacheMissionDTO;
import com.thp.spring.projetfinal.dto.TacheModeleDTO;
import com.thp.spring.projetfinal.util.Categorie;
import com.thp.spring.projetfinal.util.Type;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class MissionControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@BeforeEach
	 protected void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
	   }
	
//	@WithMockUser(roles="COLLABORATEUR")
//	@Test
//	void testAddMission() throws Exception {
//		Set<TacheMissionDTO> taskMissions = new HashSet();
//		TacheMissionDTO tacheMissionDTO = new TacheMissionDTO("visa", Categorie.DOCUMENT);
//		taskMissions.add(tacheMissionDTO);
//		this.mockMvc.perform(post("/mission")
//
//				.content(asJsonString(new MissionDTO("test", taskMissions)))
//		        .contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//
//				.andExpect(status().isOk());
//		
//	}
	
	@WithMockUser(roles="COLLABORATEUR")
	@Test
	void testGetMisiionById() throws Exception {
		this.mockMvc.perform(get("/mission?id=1")).andExpect(status().isOk());
	}

	@WithMockUser(roles="COLLABORATEUR")
	@Test
	void testGetMisiionByUtilisateur() throws Exception {
		this.mockMvc.perform(get("/mission/collab?id=30")).andExpect(status().isOk());
	}

	@WithMockUser(roles="COLLABORATEUR")
	@Test
	void testFindAllUser() throws Exception {
		this.mockMvc.perform(get("/mission")).andExpect(status().isOk());
	}

//	@WithMockUser(roles="COLLABORATEUR")

//	@Test
//	void testDeleteMission() throws Exception {
//		this.mockMvc.perform(delete("/mission/32")).andExpect(status().isOk());
//	}

	
	@WithMockUser(roles="COLLABORATEUR")
	@Test
	void testUpdateUser() throws Exception {
		Set<TacheMissionDTO> taskMissions = new HashSet();
		TacheMissionDTO tacheMissionDTO = new TacheMissionDTO("visa", Categorie.DOCUMENT);
		taskMissions.add(tacheMissionDTO);
		MissionDTO missionDTO = new MissionDTO(35L, "test ajout", taskMissions);
		this.mockMvc.perform(put("/mission")

				.content(asJsonString(missionDTO))
			        .contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))

					.andExpect(status().isOk());
	}
	

	@WithMockUser(roles="COLLABORATEUR")
	@Test
	void testGetCollaborateurOfManager() {
		fail("Not yet implemented");
	}

	@WithMockUser(roles="COLLABORATEUR")
	@Test
	void testAnnulerMissionByid() {
		fail("Not yet implemented");
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




