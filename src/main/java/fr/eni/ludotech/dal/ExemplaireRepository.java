package fr.eni.ludotech.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.eni.ludotech.bo.ExemplaireJeu;

public interface ExemplaireRepository extends JpaRepository<ExemplaireJeu, Integer>
{	
	//Trouver un exemplaire louable qui n'a pas déjà été réservé et qui correspond à un modèle de jeu donné
	@Query("SELECT e FROM ExemplaireJeu e "
		 + "WHERE e.reservationClient IS NULL "
		 + "AND e.dateReservation IS NULL "
		 + "AND e.estLouable = TRUE "
		 + "AND e.modeleJeu.id = :idJeu")
	List<ExemplaireJeu> findExemplairesNonReservesByJeu(@Param("idJeu") Integer idJeu);
}
