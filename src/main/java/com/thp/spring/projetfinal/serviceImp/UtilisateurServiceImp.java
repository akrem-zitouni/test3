package com.thp.spring.projetfinal.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thp.spring.projetfinal.dto.UtilisateurDTO;
import com.thp.spring.projetfinal.entities.UtilisateurEntity;
import com.thp.spring.projetfinal.helper.ModelMapperConverter;
import com.thp.spring.projetfinal.repository.UtilisateurRepository;
import com.thp.spring.projetfinal.service.UtilisateurService;
import com.thp.spring.projetfinal.util.Libelle;

@Service
public class UtilisateurServiceImp implements UtilisateurService {

	@Autowired
	UtilisateurRepository utilisateurRepository;



	@Override
	public UtilisateurDTO addUtilisateur(UtilisateurDTO utilisateurDTO) {
		UtilisateurEntity utilisateurEntity = ModelMapperConverter.converToEntity(utilisateurDTO,
				UtilisateurEntity.class);
		return ModelMapperConverter.converToDTO(utilisateurRepository.save(utilisateurEntity), UtilisateurDTO.class);

	}

	@Override
	public UtilisateurDTO findById(Long id) {
		UtilisateurEntity user = utilisateurRepository.findById(id).orElse(null);
		return ModelMapperConverter.converToDTO(user, UtilisateurDTO.class);
	}

	@Override
	public List<UtilisateurDTO> findAll() {
		List<UtilisateurEntity> user = utilisateurRepository.findAll();
		return ModelMapperConverter.convertAllToDTO(user, UtilisateurDTO.class);
	}

	@Override
	public UtilisateurDTO findByPseudo(String pseudo) {
		UtilisateurEntity user = utilisateurRepository.findByPseudo(pseudo);
		return ModelMapperConverter.converToDTO(user, UtilisateurDTO.class);
	}

	@Override
	public void deleteUtilisateur(Long id) {
		utilisateurRepository.deleteById(id);
	}

	@Override
	public List<UtilisateurDTO> findByManagerId(Long id) {
		return	ModelMapperConverter.convertAllToDTO(utilisateurRepository.findByManagerId(id), UtilisateurDTO.class) ;
		
				}

	@Override
	public List<UtilisateurDTO> findByRoleId(Long id) {
		
		return ModelMapperConverter.convertAllToDTO(utilisateurRepository.findByRoleId(id), UtilisateurDTO.class) ;
		
	}

	@Override
    public List<UtilisateurDTO> findCollaborateursOfManager(String pseudo) {
        UtilisateurEntity manager = utilisateurRepository.findByPseudo(pseudo);
        Long managerId = manager.getId();
        List<UtilisateurEntity> collaborateurs = utilisateurRepository.findByManagerId(managerId);
        return ModelMapperConverter.convertAllToDTO(collaborateurs, UtilisateurDTO.class);
    }

	@Override
	public List<UtilisateurDTO> findCollaborateursAndManagers() {
		List<UtilisateurEntity> listCollaborateurs = utilisateurRepository.findByRoleLibelle(Libelle.COLLABORATEUR);
		List<UtilisateurEntity> listManagers = utilisateurRepository.findByRoleLibelle(Libelle.MANAGER);
		listCollaborateurs.addAll(listManagers);
		return ModelMapperConverter.convertAllToDTO(listCollaborateurs, UtilisateurDTO.class);
	}
	@Override
	public List<UtilisateurDTO> findManagers() {
		List<UtilisateurEntity> listManagers = utilisateurRepository.findByRoleLibelle(Libelle.MANAGER);
		return ModelMapperConverter.convertAllToDTO(listManagers, UtilisateurDTO.class);
	}
}
