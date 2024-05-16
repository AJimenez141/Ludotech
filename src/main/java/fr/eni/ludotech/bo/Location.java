package fr.eni.ludotech.bo;

import java.sql.Date;
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
@Table(name="LOCATION")
public class Location {
	
	@Id
	@GeneratedValue()
	private Integer id;
	
	@Column(name="date_debut", nullable = false)
	private Date date_debut;
	
	@Column(name="est_paye", nullable = false)
	@Builder.Default private Boolean est_paye = false;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locations")
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy = "location",  cascade = CascadeType.REMOVE,  orphanRemoval = true, fetch = FetchType.LAZY)
	private List<LocationExemplaire> location_exemplaires;
}
