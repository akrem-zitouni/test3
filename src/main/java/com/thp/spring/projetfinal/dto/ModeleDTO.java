package com.thp.spring.projetfinal.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thp.spring.projetfinal.util.Type;
public class ModeleDTO extends MyDTO {

	private Long id;
	private String description;
	private String designation;
	private Type type;
	private List<TacheModeleDTO> taskModels;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public List<TacheModeleDTO> getTaskModels() {
		return taskModels;
	}
	public void setTaskModels(List<TacheModeleDTO> taskModels) {
		this.taskModels = taskModels;
	}
	public ModeleDTO(Long id, String description, String designation, Type type, List<TacheModeleDTO> taskModels) {
		super();
		this.id = id;
		this.description = description;
		this.designation = designation;
		this.type = type;
		this.taskModels = taskModels;
	}
	public ModeleDTO(String description, String designation, Type type, List<TacheModeleDTO> taskModels) {
		super();
		this.description = description;
		this.designation = designation;
		this.type = type;
		this.taskModels = taskModels;
	}
	

	public ModeleDTO(String description, String designation, Type type) {
		super();
		this.description = description;
		this.designation = designation;
		this.type = type;
	}
	public ModeleDTO() {
		super();
	}
	@Override
	public String toString() {
		return "ModelDTO [id=" + id + ", description=" + description + ", designation=" + designation + ", type=" + type
				+ ", taskModels=" + taskModels + "]";
	}

	
}
