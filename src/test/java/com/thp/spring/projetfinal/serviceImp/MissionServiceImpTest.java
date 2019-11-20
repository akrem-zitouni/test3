
//package com.thp.spring.projetfinal.serviceImp;
//
//import static org.junit.Assert.assertEquals;
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
//import com.thp.spring.projetfinal.dto.MissionDTO;
//import com.thp.spring.projetfinal.service.MissionService;
//
//@Transactional
//@Rollback(true)
//@SpringBootTest
//@ActiveProfiles("test")
//public class MissionServiceImpTest {
//	@Autowired
//	MissionService missionService;
//	

//
//	@Test
//	void testFindById() {
//		MissionDTO mission = missionService.findById( 1L);
//		assertEquals("talan", mission.getDescription());	
//	}
//
//	@Test
//	void testFindAll() {
//		List<MissionDTO> mission = missionService.findAll();
//		 assertEquals(1, mission.size());
//	}
//	@Test
//	void testDeleteMission() {
//		missionService.deleteMission(1L);
//		List<MissionDTO> missionDTOs = missionService.findAll();
//		System.out.println(missionDTOs);
//		 assertEquals(0,missionDTOs.size());
//	}
//}

