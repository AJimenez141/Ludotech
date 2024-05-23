package fr.eni.ludotech.bll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.eni.ludotech.bo.Client;
import fr.eni.ludotech.bo.ExemplaireJeu;
import fr.eni.ludotech.bo.Location;
import fr.eni.ludotech.bo.LocationExemplaire;
import fr.eni.ludotech.bo.ModeleJeu;
import fr.eni.ludotech.dal.ExemplaireRepository;
import fr.eni.ludotech.dal.LocationRepository;

@Component
public class LocationServiceImpl implements LocationService 
{
	@Autowired
	private ExemplaireRepository exemplaireRepo;
	
	@Autowired
	private LocationRepository locationRepo;

	@Override
	public Location louerJeux(List<ModeleJeu> jeux, Client client)
	{
		List<LocationExemplaire> listLocationExemplaires = new ArrayList<>();
		
		for(ModeleJeu jeu : jeux)
        {
			LocationExemplaire locationExemplaire = null;
			try 
			{
				ExemplaireJeu exemplaire = exemplaireRepo.findExemplairesNonReservesByJeu(jeu.getId()).get(0);
				
				if (!exemplaireRepo.isExemplaireAlreadyLoue(exemplaire.getId())) 
				{
					locationExemplaire = LocationExemplaire.builder()
							.exemplaireJeu(exemplaire)
							.dateFin(null)
							.prixFinal(jeu.getPrixLocation())
							.build();
					
					listLocationExemplaires.add(locationExemplaire);
				}
			} 
			catch (Exception e) 
			{
			    continue;
			}
        }
		
		if (listLocationExemplaires.size() == jeux.size()) 
		{
			Location location = Location.builder()
					.dateLocation(java.time.LocalDate.now())
					.estPaye(false)
					.locationExemplaires(listLocationExemplaires)
					.client(client).build();

			locationRepo.save(location);
			return location;
		} 
		else 
		{
			return null;
		}
	}
}
