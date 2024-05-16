package fr.eni.ludotech.bo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="EXEMPLAIRE")
public class Exemplaire {
	
	@Id
	@GeneratedValue()
	private Integer id;
	
	@Column(name="code_barre", length = 15, nullable = false)
	private String code_barre;
	
	@Column(name="est_louable", nullable = false)
	@Builder.Default Boolean est_louable = true;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "exemplaires_modele") 
	private ModeleJeu modele;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exemplaires_reservation")
	private Reservation reservation;
	
	@OneToMany(mappedBy = "exemplaire",  cascade = CascadeType.REMOVE,  orphanRemoval = true, fetch = FetchType.LAZY)
	private List<LocationExemplaire> exemplaire_locations;
}
