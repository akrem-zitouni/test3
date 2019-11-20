package com.thp.spring.projetfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thp.spring.projetfinal.dto.ModeleDTO;
import com.thp.spring.projetfinal.service.ModelService;

@RestController
@CrossOrigin("*")
public class ModeleController {

	@Autowired
	ModelService modelService;

	@PostMapping(value = "/model")
	public ModeleDTO addModel(@RequestBody ModeleDTO modelDTO) {
		return modelService.addModel(modelDTO);
	}

	@GetMapping(value = "/models")
	public List<ModeleDTO> findAll() {
		return modelService.findAll();
	}

	@GetMapping(value = "/model")
	public ModeleDTO getModel(@RequestParam Long id) {
		return modelService.findById(id);
	}

	@PutMapping(value = "/model")
	public ModeleDTO updateModel(@RequestBody ModeleDTO modelDTO) {
		return modelService.addModel(modelDTO);
	}

	@DeleteMapping(value = "/model/{idModel}")
	public void deleteModel(@PathVariable Long idModel) {
		modelService.deleleModel(idModel);
	}
}
