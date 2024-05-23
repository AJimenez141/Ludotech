package fr.eni.ludotech.bll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.eni.ludotech.bo.Client;
import fr.eni.ludotech.bo.ExemplaireJeu;
import fr.eni.ludotech.bo.Location;
import fr.eni.ludotech.bo.LocationExemplaire;
import fr.eni.ludotech.bo.ModeleJeu;
import fr.eni.ludotech.dal.ExemplaireRepository;

public class LocationServiceImpl implements LocationService 
{
	@Autowired
	private ExemplaireRepository exemplaireRepo;

	@Override
	public Location louerJeux(List<ModeleJeu> jeux, Client client)
	{
		List<LocationExemplaire> listLocationExemplaires = new ArrayList<>();
		
		LocationExemplaire locationExemplaire = null;
		for(ModeleJeu jeu : jeux)
        {
			try 
			{
				ExemplaireJeu exemplaire = exemplaireRepo.findExemplairesNonReservesByJeu(jeu.getId()).get(0);
				
				if (!exemplaireRepo.isExemplaireAlreadyLoue(exemplaire.getId())) 
				{
					locationExemplaire = LocationExemplaire.builder()
							.exemplaireJeu(exemplaire)
							.dateFin(java.time.LocalDate.now().plusDays(14))
							.prixFinal(jeu.getPrixLocation())
							.build();
				}
			} 
			catch (Exception e) 
			{
				locationExemplaire = null;
			}
			finally
			{
				if(locationExemplaire != null) listLocationExemplaires.add(locationExemplaire);
			}
        }
		
		Location location = Location.builder()
				.dateLocation(java.time.LocalDate.now())
				.estPaye(false)
				.locationExemplaires(listLocationExemplaires)
				.client(client).build();

		if (location.getLocationExemplaires().size() == jeux.size()) {
			return location;
		} else {
			return null;
		}
	}
}
