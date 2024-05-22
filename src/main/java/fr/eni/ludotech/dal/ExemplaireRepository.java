package fr.eni.ludotech.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.ludotech.bo.ExemplaireJeu;

public interface ExemplaireRepository extends JpaRepository<ExemplaireJeu, Integer>{

	
}
