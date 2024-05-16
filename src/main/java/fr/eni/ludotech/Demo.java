package fr.eni.ludotech;

import java.util.ArrayList;
import java.util.List;

import fr.eni.ludotech.bo.Genre;
import fr.eni.ludotech.bo.ModeleJeu;

public class Demo {

	public static void main(String[] args) {
		
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
	}
}
