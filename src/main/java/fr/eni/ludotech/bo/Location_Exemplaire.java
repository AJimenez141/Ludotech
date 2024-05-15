package fr.eni.ludotech.bo;

import java.sql.Date;

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
@Table(name="LOCATION_EXEMPLAIRE")
public class Location_Exemplaire {
	@Id
	@GeneratedValue()
	private Integer id;
	
	@Column(name="date_fin", nullable = true)
	private Date date_fin;
	
	@Column(name="prix_final", nullable = true)
	private Float prix_final;
}