//
//package com.thp.spring.projetfinal.serviceImp;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.thp.spring.projetfinal.dto.RoleDTO;
//import com.thp.spring.projetfinal.dto.UtilisateurDTO;
//import com.thp.spring.projetfinal.entities.RoleEntity;
//import com.thp.spring.projetfinal.service.UtilisateurService;
//
//@Transactional
//@Rollback(true)
//@SpringBootTest
//@ActiveProfiles("test")
//class UtilisateurServiceImpTest {
//	@Autowired
//	UtilisateurService utilisateurService;
//	
//	
//
////	@Test
////	void testAddUtilisateur() {
////		
////		UtilisateurDTO utilisateurDTO = new UtilisateurDTO("akrem", "zitouni", "moez@gmial.com");
////		UtilisateurDTO utilisateurDTO1 = utilisateurService.addUtilisateur(utilisateurDTO);
////		assertEquals(utilisateurDTO.getPseudo(), utilisateurDTO1.getPseudo());
////		utilisateurService.deleteUtilisateur(1L);
////	}
//
//	@Test
//	void testFindById() {
//		UtilisateurDTO utilisateur = utilisateurService.findById( 1L);
//		assertEquals("moez", utilisateur.getPseudo());	
//	}
//
//	@Test
//	void testFindAll() {
//		List<UtilisateurDTO> utlisateurs = utilisateurService.findAll();
//		 assertEquals(1, utlisateurs.size());
//	}
//
//	@Test
//	void testFindByPseudo() {
//		UtilisateurDTO utilisateurDTO = utilisateurService.findByPseudo("tunis");
//		assertEquals("moez", utilisateurDTO.getPseudo());
//	}
//
//	@Test
//	void testDeleteUtilisateur() {
//		utilisateurService.deleteUtilisateur(1L);
//		List<UtilisateurDTO> utlisateurDTOs = utilisateurService.findAll();
//		System.out.println(utlisateurDTOs);
//		 assertEquals(0,utlisateurDTOs.size());
//	}
//
//}
//
