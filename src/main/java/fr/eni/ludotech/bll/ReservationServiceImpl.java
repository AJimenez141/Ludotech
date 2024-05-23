package fr.eni.ludotech.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.eni.ludotech.bo.ExemplaireJeu;
import fr.eni.ludotech.bo.ModeleJeu;
import fr.eni.ludotech.bo.Client;
import fr.eni.ludotech.dal.ExemplaireRepository;

@Component
public class ReservationServiceImpl implements ReservationService 
{	
	@Autowired
	private ExemplaireRepository exemplaireRepo;

	@Override
	public ExemplaireJeu reserverJeu(ModeleJeu modele, Client client) 
	{
		try 
		{
			ExemplaireJeu exemplaire = exemplaireRepo.findExemplairesNonReservesByJeu(modele.getId()).get(0);
			
			//Vérifier que cet exemplaire n'a pas déjà été empunté par un autre client
			if (exemplaireRepo.isExemplaireAlreadyLoue(exemplaire.getId())) 
			{
				return null;
			}
			//Sinon, réserver l'exemplaire pour le client
			else
			{
				exemplaire.setReservationClient(client);
				exemplaire.setDateReservation(java.time.LocalDate.now());
				exemplaireRepo.save(exemplaire);
				return exemplaire;
			}
		}
		catch (Exception e) {
			return null;
		}
	}
}
