package fr.eni.ludotech.bo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@ToString
@Builder
@Entity
@Table(name="MODELE_JEU")
public class ModeleJeu {
	
	@Id
	@GeneratedValue()
	private Integer id;
	
	@Column(name="nom", nullable = false)
	private String nom;
	
	@Column(name="prix_location", nullable = false)
	private Float prix_location;

	@OneToMany(mappedBy = "modele",  cascade = CascadeType.REMOVE,  orphanRemoval = true,  fetch = FetchType.LAZY)
	private List<Exemplaire> exemplaires;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "GENRE_MODELE",
	    joinColumns = {@JoinColumn(name = "GENRE_FK", referencedColumnName = "genres" )}, // ID ist die Id von Einsatz
	    inverseJoinColumns = {@JoinColumn( name = "MODELE_JEU_FK", referencedColumnName = "modeles_jeux" )} // ID ist die Id von Mitglied
	  )
	private List<Genre> genres;
}
