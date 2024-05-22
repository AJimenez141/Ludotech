package fr.eni.ludotech.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import fr.eni.ludotech.bo.Client;
import fr.eni.ludotech.bo.ExemplaireJeu;
import fr.eni.ludotech.bo.Genre;
import fr.eni.ludotech.bo.ModeleJeu;

class DALTest {

	@Test
	void test() {
		//ARRANGE
		
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
				.prixLocation(3.10)
				.genres(liste1)
				.build();

		ModeleJeu monopoly = ModeleJeu.builder()
				.nom("uno")
				.prixLocation(3.10)
				.genres(liste2)
				.build();
		
		ExemplaireJeu uno1 = ExemplaireJeu.builder()
				.codeBarre("124563482510212")
				.estLouable(true)
				.modeleJeu(uno)
				.build();
				
		ExemplaireJeu uno2 = ExemplaireJeu.builder()
				.codeBarre("124563457610212")
				.estLouable(true)
				.modeleJeu(uno)
				.build();
		
		ExemplaireJeu monopoly1 = ExemplaireJeu.builder()
				.codeBarre("124563482575435")
				.estLouable(true)
				.modeleJeu(monopoly)
				.build();
		
		List<ExemplaireJeu> liste3 = new ArrayList<ExemplaireJeu>();
		liste3.add(uno1);
		liste3.add(uno2);
		liste3.add(monopoly1);
		
		
		Client client1 = Client.builder()
				.nom("La Banane")
				.prenom("Bernard")
				.email("bernard@banane.fr")
				.password("bnrogzp")
				.build();
	}

}
