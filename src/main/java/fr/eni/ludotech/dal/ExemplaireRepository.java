package fr.eni.ludotech.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.eni.ludotech.bo.ExemplaireJeu;

public interface ExemplaireRepository extends JpaRepository<ExemplaireJeu, Integer>{

	//Trouver un exemplaire qui n'a pas été réservé par un client
	@Query("SELECT e FROM ExemplaireJeu e WHERE e.reservationClient IS NULL AND e.dateReservation IS NULL")
	List<ExemplaireJeu> findExemplairesNonReserves();
}
