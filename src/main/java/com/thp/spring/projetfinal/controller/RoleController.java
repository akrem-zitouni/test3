package com.thp.spring.projetfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thp.spring.projetfinal.dto.RoleDTO;
import com.thp.spring.projetfinal.service.RoleService;
@RestController
@CrossOrigin("*")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@GetMapping(value = "/roles")
	public List<RoleDTO> findAllRole() {
		return roleService.findAll();

	}
}
