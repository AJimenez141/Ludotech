package fr.eni.ludotech.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.ludotech.bo.Client;
import fr.eni.ludotech.bo.Location;
import fr.eni.ludotech.bo.LocationExemplaire;
import fr.eni.ludotech.bo.ModeleJeu;
import fr.eni.ludotech.dal.ExemplaireJeuRepository;
import fr.eni.ludotech.dal.LocationRepository;
import fr.eni.ludotech.bo.ExemplaireJeu;
import fr.eni.ludotech.dto.LocationDTO;
import fr.eni.ludotech.exception.JeuxNonDisponible;

@Service
public class LocationServiceImpl implements LocationService 
{
	private LocationRepository locationRepo;
	@Autowired
	private ExemplaireJeuRepository exemplaireRepo;

	@Override
	public Location louerJeux(List<ModeleJeu> jeux, Client client)
	{
		Location location = new Location();
		LocationExemplaire locationExemplaire = new LocationExemplaire();

		return null;
	}
	
	public LocationServiceImpl(LocationRepository locationRepo, ExemplaireJeuRepository jeuRepo) {
		this.locationRepo = locationRepo;
		this.exemplaireRepo = jeuRepo;
	}
	
	@Override
	public Location louerExemplaires(LocationDTO demandeLocation) {
		
		List<ExemplaireJeu> nonDisponibles = exemplaireRepo.findExemplairesJeuxNonDisponible(new ArrayList<Integer>(demandeLocation.getJeuxIds()));
		if(nonDisponibles.size()>0) {
			throw new JeuxNonDisponible();
		}
		
		List<LocationExemplaire> exemplairesLoues = 
				demandeLocation.getJeuxIds().stream()
					.map(idExemplaire->LocationExemplaire
								.builder()
								.jeu(ExemplaireJeu.builder().id(idExemplaire).build())
								.build())
					.toList();
		
		Location location = Location.builder()
				.client(Client.builder().id(demandeLocation.getClientId()).build())
				.dateLocation(LocalDate.now())
				.estPaye(false)
				.exemplairesLoues(exemplairesLoues)
				.build();
		
		location = locationRepo.save(location);
		
		return location;
	}
	

	@Override
	public void reserverModeleJeu(Client client, ModeleJeu modeleJeu) {
		ExemplaireJeu premierJeuDispo = exemplaireRepo.findPremierExemplaireJeuDisponible(modeleJeu.getId());
		
		if(premierJeuDispo==null) {
			throw new JeuxNonDisponible();
		}
		
		premierJeuDispo.setReservationClient(client);
		exemplaireRepo.save(premierJeuDispo);
	}
	
	@Override
	public List<ModeleJeu> modeleJeuxDisponibles() {
		return exemplaireRepo.findModelesJeuxDisponible();
	}

	@Override
	public List<ExemplaireJeu> listerExemplaires() {
		List<ExemplaireJeu> exemplaires = exemplaireRepo.findAll();
		return exemplaires;
	}
	

}
