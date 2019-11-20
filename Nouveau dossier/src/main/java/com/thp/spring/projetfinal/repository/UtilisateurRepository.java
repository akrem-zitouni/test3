package com.thp.spring.projetfinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thp.spring.projetfinal.entities.UtilisateurEntity;
import com.thp.spring.projetfinal.util.Libelle;

@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Long> {

	UtilisateurEntity findByPseudo(String pseudo);
	List<UtilisateurEntity> findByManagerId(Long id);
	List<UtilisateurEntity> findByRoleId(Long id);
	List<UtilisateurEntity> findByRoleLibelle(Libelle libelle);

}
