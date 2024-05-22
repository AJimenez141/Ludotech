package fr.eni.ludotech.dal;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.eni.ludotech.bo.Exemplaire;
import fr.eni.ludotech.bo.LocationExemplaire;
import fr.eni.ludotech.bo.LocationExemplairePK;
import fr.eni.ludotech.bo.Reservation;
import fr.eni.ludotech.bo.Utilisateur;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

	/*@Query("INSERT INTO RESERVATION r (date_reservation, utilisateur, exemplaires_reservation) VALUES(?, ?, ?)")*/
	Reservation save(Reservation resa);
	
	
	
	//List<Exemplaire> findExemplairesByModele(@Param("modele_id") Integer modele_id);
}
