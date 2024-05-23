package fr.eni.ludotech.bll;

import org.springframework.beans.factory.annotation.Autowired;

import fr.eni.ludotech.bo.ExemplaireJeu;
import fr.eni.ludotech.bo.ModeleJeu;
import fr.eni.ludotech.bo.Client;
import fr.eni.ludotech.dal.ExemplaireRepository;
import fr.eni.ludotech.dal.UtilisateurRepository;

public class ReservationServiceImpl implements ReservationService 
{	
	@Autowired
	private ExemplaireRepository exemplaireRepo;
	
	@Autowired
	private UtilisateurRepository utilisateurRepo;

	@Override
	public ExemplaireJeu reserverJeu(ModeleJeu modele, Client client) throws Exception 
	{
		ExemplaireJeu exemplaire = exemplaireRepo.findExemplairesNonReservesByJeu(modele.getId()).get(0);
		
		if (exemplaire != null) 
		{
			exemplaire.setReservationClient(client);
			exemplaireRepo.save(exemplaire);
			return exemplaire;
		}
		else 
		{
			throw new Exception("Aucun exemplaire disponible pour ce jeu");
		}
	}
}
