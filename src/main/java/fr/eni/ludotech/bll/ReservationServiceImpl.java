package fr.eni.ludotech.bll;

import java.util.List;

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
		ExemplaireJeu exemplaire = null;
		
		List<ExemplaireJeu> exemplairesNonRsv = exemplaireRepo.findExemplairesNonReservesByJeu(modele.getId());
		
		for(ExemplaireJeu exemplaireNonRsv : exemplairesNonRsv)
		{
			//Vérifier que cet exemplaire n'a pas déjà été empunté par un autre client
			if (!exemplaireRepo.isExemplaireAlreadyLoue(exemplaireNonRsv.getId())) 
			{
				exemplaire = ExemplaireJeu.builder()
						.id(exemplaireNonRsv.getId())
						.dateReservation(java.time.LocalDate.now())
						.modeleJeu(modele)
						.reservationClient(client)
						.build();
				
				exemplaireRepo.save(exemplaire);
				break;
			}
		}
		return exemplaire;
	}
}
