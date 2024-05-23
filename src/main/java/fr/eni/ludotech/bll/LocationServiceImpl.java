package fr.eni.ludotech.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.eni.ludotech.bo.Client;
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
		Location location = new Location();
		LocationExemplaire locationExemplaire = new LocationExemplaire();

		return null;
	}

}
