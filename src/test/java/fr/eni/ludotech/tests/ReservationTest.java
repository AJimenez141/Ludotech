package fr.eni.ludotech.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.eni.ludotech.bll.ReservationServiceImpl;
import fr.eni.ludotech.bo.ModeleJeu;
import fr.eni.ludotech.bo.Adresse;
import fr.eni.ludotech.bo.Client;
import fr.eni.ludotech.bo.ExemplaireJeu;
import fr.eni.ludotech.bo.Genre;
import fr.eni.ludotech.dal.ExemplaireRepository;
import fr.eni.ludotech.dal.ModeleJeuRepository;
import fr.eni.ludotech.dal.UtilisateurRepository;
import fr.eni.ludotech.dal.GenreRepository;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class ReservationTest 
{
	@Autowired
	ReservationServiceImpl reservationService;
	
	@Autowired
	UtilisateurRepository utilisateurRepo;
	
	@Autowired
	GenreRepository genreRepo;
	
	@Autowired
	ModeleJeuRepository modeleJeuRepo;
	
	@Autowired
	ExemplaireRepository exemplaireJeuRepo;

	@Test
	void test() 
	{
		//Tester l'insertion d'un genre de jeu
		Genre genre = Genre.builder()
		.libelle("Stratégie")
		.build();
		genre = genreRepo.save(genre);
		
		log.info("Genre inséré : " + genre);
		assertNotNull(genre);
		
		//Tester l'insertion d'un modèle de jeu
		ModeleJeu modele = ModeleJeu.builder()
		.nom("Monopoly")
		.prixLocation(10)
		.build();
		
		modele = modeleJeuRepo.save(modele);
		
		log.info("Modèle inséré : " + modele);
		assertNotNull(modele);
		
		//Tester l'insertion d'un exemplaire de jeu
	    ExemplaireJeu exemplaire = ExemplaireJeu.builder()
		.codeBarre("1234567890")
		.estLouable(true)
		.modeleJeu(modele)
		.build();
	    
		exemplaire = exemplaireJeuRepo.save(exemplaire);

		log.info("Exemplaire inséré : " + exemplaire);
		assertNotNull(exemplaire);
		
		//Tester l'insertion d'un client
		Client client = Client.builder().nom("DUPONT")
		.prenom("Jean")
		.email("jdupont@mail.com")
		.password("password")
		.telephone("0102030405")
		.adresse(Adresse.builder().rue("1 rue de la Paix").codePostal("75001").ville("Paris").build())
		.build();
		
		client = utilisateurRepo.save(client);
		assertNotNull(client);
		
		//Tester la réservation d'un jeu
		ExemplaireJeu exemplaireTest = null;
		try 
		{
			exemplaireTest = reservationService.reserverJeu(modele, client);
		} 
		catch (Exception e) 
		{
			log.error(e.getMessage());
		}
		
		log.info("Exemplaire réservé : " + exemplaireTest);
		assertNotNull(exemplaireTest);
	}
}
