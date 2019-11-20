package com.thp.spring.projetfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thp.spring.projetfinal.entities.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String>{
	

}
