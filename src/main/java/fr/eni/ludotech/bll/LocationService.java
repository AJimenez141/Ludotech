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
	
	Location louerJeux(List<ModeleJeu> jeux, Client client);
	
	List<ExemplaireJeu> listerExemplaires();
	
//	void reserverExemplaires(Client client, List<ExemplaireJeu> jeux);
	
//	boolean estDisponible(Integer idExemplaireJeu);
	
//	List<ExemplaireJeu> jeuxDisponibles();
	
	List<ModeleJeu> modeleJeuxDisponibles();
	
}
