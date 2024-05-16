package fr.eni.ludotech.bo;

import java.util.Date;
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
@Table(name="RESERVATION")
public class Reservation {
	
	@Id
	@GeneratedValue()
	private Integer id;
	
	@Column(name="date_reservation", nullable = false)
	private Date date_reservation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reservations")
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy = "reservation",  orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Exemplaire> exemplaires_reservation;

}
