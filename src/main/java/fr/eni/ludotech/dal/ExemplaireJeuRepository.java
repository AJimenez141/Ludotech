package fr.eni.ludotech.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.eni.ludotech.bo.ExemplaireJeu;
import fr.eni.ludotech.bo.ModeleJeu;

public interface ExemplaireJeuRepository extends JpaRepository<ExemplaireJeu, Integer>{

	public ExemplaireJeu findByCodeBarre(String codeBarre);
	
	@Query(value = "select distinct ej.modele_jeu_id from exemplaire_jeu ej "
			+ "where ej.est_louable = 1  "
			+ "and ej.reservation_client_id is null "
			+ "and ej.id not in (select jeu_id from location_exemplaire where date_fin is null)",
			nativeQuery=true)
	public List<ModeleJeu> findModelesJeuxDisponible(); 

	
	@Query(value = "select top 1 ej.* from exemplaire_jeu ej "
			+ "where ej.modele_jeu_id=:idModeleJeu "
			+ "and ej.est_louable = 1  "
			+ "and ej.reservation_client_id is null "
			+ "and ej.id not in (select jeu_id from location_exemplaire where date_fin is null)",
			nativeQuery=true)
	public ExemplaireJeu findPremierExemplaireJeuDisponible(@Param("idModeleJeu") Integer idModeleJeu); 

	@Query(value = "select ej.* from exemplaire_jeu ej "
			+ "where (ej.est_louable <> 1  "
			+ "or ej.reservation_client_id is not null "
			+ "or ej.id in (select jeu_id from location_exemplaire where date_fin is null)) "
			+ "and ej.id in :liste_jeux_id",
			nativeQuery=true)
	public List<ExemplaireJeu> findExemplairesJeuxNonDisponible(@Param("liste_jeux_id")List<Integer> jeux_id_liste); 

}