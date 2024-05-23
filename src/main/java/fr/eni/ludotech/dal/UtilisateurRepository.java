package fr.eni.ludotech.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.ludotech.bo.Utilisateur;
import java.util.List;
import java.util.Optional;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{

	Optional<Utilisateur> findById(Integer id);
	
}
