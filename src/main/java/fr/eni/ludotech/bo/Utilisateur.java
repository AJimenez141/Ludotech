package fr.eni.ludotech.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Table(name="UTILISATEUR")
public class Utilisateur {
	
	@Id
	@GeneratedValue()
	private Integer id;
	
	@Column(name="nom", length = 50, nullable = false)
	private String nom;
	
	@Column(name="prenom", length = 50, nullable = false)
	private String prenom;
	
	//Faire la relation adresse
	
	@Column(name="estClient")
	private boolean estClient; //False = Employe
	
	@Column(name="numTel", length = 10, nullable = false)
	private String numTel;
}
