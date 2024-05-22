package fr.eni.ludotech.bll;

import fr.eni.ludotech.bo.ExemplaireJeu;
import fr.eni.ludotech.bo.ModeleJeu;
import fr.eni.ludotech.bo.Utilisateur;

public interface ReservationService {
	
	ExemplaireJeu reserverJeu(ModeleJeu modele, Utilisateur utilisateur) throws Exception;

}
