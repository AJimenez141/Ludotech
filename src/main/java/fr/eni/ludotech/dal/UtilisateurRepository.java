package fr.eni.ludotech.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.ludotech.bo.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{

	
}
