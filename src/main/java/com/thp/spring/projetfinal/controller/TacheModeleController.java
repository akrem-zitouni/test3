package com.thp.spring.projetfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thp.spring.projetfinal.dto.TacheModeleDTO;
import com.thp.spring.projetfinal.service.TaskModeleService;

@RestController
@CrossOrigin("*")

public class TacheModeleController {
	@Autowired
	TaskModeleService taskModeleService;

	@PostMapping(value = "/taskModele")
	public TacheModeleDTO ajouterTaskModele(@RequestBody TacheModeleDTO taskModeleDTO) {

		return taskModeleService.ajoutTaskModele(taskModeleDTO);

	}

	@GetMapping(value = "taskModele")
	public List<TacheModeleDTO> afficherTasks() {
		return taskModeleService.findAll();

	}

	@GetMapping(value = "/taskModele/{id}")
	public TacheModeleDTO getModel(@PathVariable Long id) {
		return taskModeleService.findById(id);
	}

	@PutMapping(value = "task/{id}")
	public TacheModeleDTO updateTasksModel(@PathVariable("nom") Long idTaskModele,
			@RequestBody TacheModeleDTO taskModeleDTO) {
		TacheModeleDTO currentTaskModele = taskModeleService.findById(idTaskModele);

		return taskModeleService.ajoutTaskModele(currentTaskModele);

	}

}
