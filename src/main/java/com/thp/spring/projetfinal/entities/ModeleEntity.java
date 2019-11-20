package com.thp.spring.projetfinal.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.thp.spring.projetfinal.util.Type;
@Entity
@Table(name = "model")
public class ModeleEntity extends MyEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2152400497335912847L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "description")
	private String description;
	@Column(name = "designation")
	private String designation;
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<TacheModeleEntity> taskModels;

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

	public List<TacheModeleEntity> getTaskModels() {
		return taskModels;
	}

	public void setTaskModels(List<TacheModeleEntity> taskModels) {
		this.taskModels = taskModels;
	}

	public ModeleEntity(Long id, String description, String designation, Type type, List<TacheModeleEntity> taskModels) {
		super();
		this.id = id;
		this.description = description;
		this.designation = designation;
		this.type = type;
		this.taskModels = taskModels;
	}

	public ModeleEntity(String description, String designation, Type type, List<TacheModeleEntity> taskModels) {
		super();
		this.description = description;
		this.designation = designation;
		this.type = type;
		this.taskModels = taskModels;
	}

	public ModeleEntity() {
		super();

	}

	@Override
	public String toString() {
		return "ModelEntity [id=" + id + ", description=" + description + ", designation=" + designation + ", type="
				+ type + ", taskModels=" + taskModels + "]";
	}
	
	
	
	
}
