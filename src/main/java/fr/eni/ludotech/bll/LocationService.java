package fr.eni.ludotech.bll;

import java.util.List;

import fr.eni.ludotech.bo.Client;
import fr.eni.ludotech.bo.ExemplaireJeu;
import fr.eni.ludotech.bo.Location;
import fr.eni.ludotech.bo.ModeleJeu;
import fr.eni.ludotech.dto.LocationDTO;

public interface LocationService {

	Location louerExemplaires(LocationDTO demandeLocation);
	
	void reserverModeleJeu(Client client, ModeleJeu modeleJeu);
	
	List<ExemplaireJeu> listerExemplaires();
	
	void ajouterExemplaire(ExemplaireJeu exemplaire);
	
	void supprimerExemplaire(Integer id);
	
	ExemplaireJeu modifierExemplaire(ExemplaireJeu exemplaire);
	
//	void reserverExemplaires(Client client, List<ExemplaireJeu> jeux);
	
//	boolean estDisponible(Integer idExemplaireJeu);
	
//	List<ExemplaireJeu> jeuxDisponibles();
	
	List<ModeleJeu> modeleJeuxDisponibles();
	
}
