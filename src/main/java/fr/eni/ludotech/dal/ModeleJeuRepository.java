package fr.eni.ludotech.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.eni.ludotech.bo.ModeleJeu;

public interface ModeleJeuRepository extends JpaRepository<ModeleJeu, Integer> {
	
	@Query(value = "select distinct mj.id, mj.nom, mj.prix from modele_jeu mj "
			+ "inner join exemplaire_jeu ej on ej.modele_jeu_id = mj.id "
			+ "where ej.est_louable = 1  "
			+ "and ej.reservation_client_id is null "
			+ "and ej.id not in (select jeu_id from location_exemplaire where date_fin is null)",
			nativeQuery=true)
	List<ModeleJeu> findModelesDisponible();

}
