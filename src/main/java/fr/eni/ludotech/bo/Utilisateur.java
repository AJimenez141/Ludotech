package fr.eni.ludotech.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
@Table(name="UTILISATEUR")
public class Utilisateur {
	
	@Id
	@GeneratedValue()
	Integer id;
	
	@Column(name="nom", length = 50, nullable = false)
	String nom;
	
	@Column(name="prenom", length = 50, nullable = false)
	String prenom;
	
	@Embedded
	Adresse adresse;
	
	@Column(name="estClient")
	boolean estClient; //False = Employe

}
