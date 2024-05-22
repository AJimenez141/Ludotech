package fr.eni.ludotech.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import fr.eni.ludotech.bo.Exemplaire;
import fr.eni.ludotech.bo.Genre;
import fr.eni.ludotech.bo.ModeleJeu;
import fr.eni.ludotech.bo.Reservation;
import fr.eni.ludotech.bo.Utilisateur;
import fr.eni.ludotech.dal.ReservationRepository;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
//@DataJpaTest
@Slf4j
@TestMethodOrder(MethodOrderer.MethodName.class)
class ReservationTest {
	
	@Autowired
	private ReservationRepository locExeRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	void test() {
		//Arrange
		
		
		Genre strategie = Genre.builder()
				.libelle("strategie")
				.build();
		Genre cartes = Genre.builder()
				.libelle("cartes")
				.build();
		Genre plateau = Genre.builder()
				.libelle("plateau")
				.build();
		
		List<Genre> liste1 = new ArrayList<Genre>();
		liste1.add(cartes);
		liste1.add(strategie);
		
		List<Genre> liste2 = new ArrayList<Genre>();
		liste2.add(plateau);
		liste2.add(strategie);
		
		ModeleJeu uno = ModeleJeu.builder()
				.nom("uno")
				.prix_location(3.10)
				.genres(liste1)
				.build();

		ModeleJeu monopoly = ModeleJeu.builder()
				.nom("uno")
				.prix_location(3.10)
				.genres(liste2)
				.build();
		
		Exemplaire uno1 = Exemplaire.builder()
				.code_barre("124563482510212")
				.est_louable(true)
				.modele(uno)
				.build();
				
		Exemplaire uno2 = Exemplaire.builder()
				.code_barre("124563457610212")
				.est_louable(true)
				.modele(uno)
				.build();
		
		Exemplaire monopoly1 = Exemplaire.builder()
				.code_barre("124563482575435")
				.est_louable(true)
				.modele(monopoly)
				.build();
		
		List<Exemplaire> liste3 = new ArrayList<Exemplaire>();
		liste3.add(uno1);
		liste3.add(uno2);
		liste3.add(monopoly1);
		
		Reservation resa1 = Reservation.builder()
				.date_reservation(LocalDate.now())
				.exemplaires_reservation(liste3)
				.build();
		
		Utilisateur user1 = Utilisateur.builder()
				.nom("La Banane")
				.prenom("Bernard")
				.numTel("0123456978")
				.estClient(true)
				.build();
		
		entityManager.persist(strategie);
		entityManager.persist(cartes);
		entityManager.persist(plateau);

		entityManager.persist(uno);
		entityManager.persist(monopoly);
		
		entityManager.persist(uno1);
		entityManager.persist(uno2);
		entityManager.persist(monopoly1);
		
		entityManager.persist(user1);
		
		//TODO passer tout le code au dessus dans le import.sql -> delete de toutes les données table + insertion
		
		for(int i = 0; i < liste3.size(); i++)
		{
			assertThat(liste3.get(i).getEst_louable()).isTrue();
		}
		
		locExeRepo.save(resa1);
		
		log.info(liste3.toString());
	}

}
