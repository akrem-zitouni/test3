  INSERT INTO role(id, libelle)
	VALUES (1, 'COLLABORATEUR');

	
INSERT INTO utilisateur(
	id, adresse, cin, code_postal, mail, mot_de_passe, nom, prenom, pseudo, tel, ville, manager_id, role_id)
	VALUES (1, 'tunis', 'tunis', 'tunis', 'tunis', 'tunis', 'tunis', 'tunis', 'tunis', 'tunis', 'tunis', null, 1);

	


INSERT INTO tache_mission(
	id_tachesmission, date_affectation, date_echeance, task_models, utilisateur_id)
	VALUES (1, null, null, 1, 1);