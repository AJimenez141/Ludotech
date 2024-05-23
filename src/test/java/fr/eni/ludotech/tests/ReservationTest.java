package fr.eni.ludotech.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
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
@TestInstance(Lifecycle.PER_CLASS)
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
	
	@BeforeAll
	void insertJeuEssai()
	{
	    // Insertion de plusieurs genres de jeu
	    List<Genre> genres = Arrays.asList(
	        Genre.builder().libelle("Stratégie").build(),
	        Genre.builder().libelle("Aventure").build(),
	        Genre.builder().libelle("Action").build()
	    );
	    genres = genreRepo.saveAll(genres);
	    genres.forEach(genre -> log.info("Genre inséré : " + genre));

	 // Insertion de plusieurs modèles de jeu et attribution des genres
	    List<ModeleJeu> modeles = Arrays.asList(
	        ModeleJeu.builder().nom("Monopoly").prixLocation(10)
	            .genres(Arrays.asList(genres.get(0))) // Stratégie
	            .build(),
	        ModeleJeu.builder().nom("Risk").prixLocation(12)
	            .genres(Arrays.asList(genres.get(0))) // Stratégie
	            .build(),
	        ModeleJeu.builder().nom("Catan").prixLocation(15)
	            .genres(Arrays.asList(genres.get(0), genres.get(1))) // Stratégie et Aventure
	            .build()
	    );
	    modeles = modeleJeuRepo.saveAll(modeles);
	    modeles.forEach(modele -> log.info("Modèle inséré : " + modele));

	 // Insertion de plusieurs exemplaires de jeu
	    List<ExemplaireJeu> exemplaires = new ArrayList<>();
	    for (ModeleJeu modele : modeles) {
	        for (int i = 0; i < 2; i++) {
	            ExemplaireJeu exemplaire = ExemplaireJeu.builder()
	                .codeBarre(UUID.randomUUID().toString())
	                .estLouable(i != 0) // Définir le premier exemplaire de chaque modèle comme non louable
	                .modeleJeu(modele)
	                .build();
	            exemplaires.add(exemplaire);
	        }
	    }
	    exemplaires = exemplaireJeuRepo.saveAll(exemplaires);
	    exemplaires.forEach(exemplaire -> log.info("Exemplaire inséré : " + exemplaire));

	    // Insertion de plusieurs clients
	    List<Client> clients = Arrays.asList(
	        Client.builder()
	            .nom("DUPONT").prenom("Jean").email("jdupont@mail.com").password("password")
	            .telephone("0102030405")
	            .adresse(Adresse.builder().numero("1").rue("rue de la Paix").codePostal("75001").ville("Paris").build())
	            .build(),
	        Client.builder()
	            .nom("MARTIN").prenom("Pierre").email("pmartin@mail.com").password("password")
	            .telephone("0607080910")
	            .adresse(Adresse.builder().numero("2").rue("rue de la Liberté").codePostal("75002").ville("Paris").build())
	            .build(),
	        Client.builder()
	            .nom("DURAND").prenom("Marie").email("mdurand@mail.com").password("password")
	            .telephone("0506070809")
	            .adresse(Adresse.builder().numero("3").rue("rue du Commerce").codePostal("75003").ville("Paris").build())
	            .build()
	    );
	    clients = utilisateurRepo.saveAll(clients);
	    clients.forEach(client -> log.info("Client inséré : " + client));
	}


	@Test
	//Tester la réservation d'un jeu
	void testResaJeu() 
	{
		ModeleJeu modeleMonopoly = modeleJeuRepo.findById(1).get();
		
		//Cas où la réservation est possible
		Client clientJDupont = (Client) utilisateurRepo.findById(1).get();
		ExemplaireJeu exemplaireTest = reservationService.reserverJeu(modeleMonopoly, clientJDupont);
		
		assertNotNull(exemplaireTest);
		assertEquals(modeleMonopoly, exemplaireTest.getModeleJeu());
		assertEquals(clientJDupont, exemplaireTest.getReservationClient());
		
		log.info("L'exemplaire " + exemplaireTest.getId() 
		+ " du jeu " + exemplaireTest.getModeleJeu().getNom() 
		+ " a bien été réservé par " + clientJDupont.getPrenom() + " " + clientJDupont.getNom() 
		+ " le " + exemplaireTest.getDateReservation());
		
		//Cas où la réservation n'est pas possible
		Client clientPMartin = (Client) utilisateurRepo.findById(2).get();
		ExemplaireJeu exemplaireTest2 = reservationService.reserverJeu(modeleMonopoly, clientPMartin);

		assertNull(exemplaireTest2);
		
		log.info("Le jeu " + modeleMonopoly.getNom() 
		+ " n'a pas pu être réservé par " 
		+ clientPMartin.getPrenom() + " " + clientPMartin.getNom()
		+ " car il n'y a plus d'exemplaires disponibles");
	}
}
