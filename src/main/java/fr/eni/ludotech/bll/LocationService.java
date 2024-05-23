package fr.eni.ludotech.bll;

import java.util.List;

import fr.eni.ludotech.bo.Client;
import fr.eni.ludotech.bo.Location;
import fr.eni.ludotech.bo.ModeleJeu;

public interface LocationService 
{
	Location louerJeux(List<ModeleJeu> jeux, Client client) throws Exception;
}
