package fr.eni.ludotech.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.ludotech.bo.ModeleJeu;

public interface ModeleJeuRepository extends JpaRepository<ModeleJeu, Integer> {

}
