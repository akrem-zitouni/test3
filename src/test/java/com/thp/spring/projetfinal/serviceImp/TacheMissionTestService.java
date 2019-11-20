///**
// * 
// */
//package com.thp.spring.projetfinal.serviceImp;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.thp.spring.projetfinal.dto.TacheMissionDTO;
//import com.thp.spring.projetfinal.service.TacheMissionService;
//
///**
// * @author abouabid
// *
// */
//@Transactional
//@Rollback(true)
//@SpringBootTest
//@ActiveProfiles("test")
//class TacheMissionTestService {
//
//	TacheMissionService tacheMissionService;
//	/**
//	 * Test method for {@link com.thp.spring.projetfinal.serviceImp.TacheMissionServiceImpl#findAll()}.
//	 */
//	@Test
//	void testFindAll() {
//		List<TacheMissionDTO> task = tacheMissionService.findAll();
//		 assertEquals(1, task.size());
//	}
//
//}
