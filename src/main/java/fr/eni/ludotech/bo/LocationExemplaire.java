package fr.eni.ludotech.bo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(of="id")
@ToString
@Builder
@Entity
@IdClass(LocationExemplairePK.class)
@Table(name="LOCATION_EXEMPLAIRE")
public class LocationExemplaire {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_exemplaires")
	private Location location;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exemplaire_locations")
	private Exemplaire exemplaire;
	
	@Column(name="date_fin", nullable = true)
	private Date date_fin;
	
	@Column(name="prix_final", nullable = true)
	private Float prix_final;
}