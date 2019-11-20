package com.thp.spring.projetfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thp.spring.projetfinal.entities.RoleEntity;
import com.thp.spring.projetfinal.util.Libelle;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

	RoleEntity findByLibelle(Libelle libelle);
}
