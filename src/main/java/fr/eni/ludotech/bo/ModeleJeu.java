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
@Table(name="MODELE_JEU")
public class ModeleJeu {
	
	@Id
	@GeneratedValue()
	private Integer id;
	
	@Column(name="nom", nullable = false)
	private String nom;
	
	@Column(name="prix_location", nullable = false)
	private Float prix_location;

}
