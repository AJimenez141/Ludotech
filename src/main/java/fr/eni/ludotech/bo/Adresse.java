package fr.eni.ludotech.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name="ADRESSE")
public class Adresse {
	
	@Id
	@GeneratedValue()
	private Integer id;
	
	@Column(name="rue", length = 50, nullable = false)
	private String rue;
	
	@Column(name="codePos", length = 5, nullable = false)
	private String codePos;
	
	@Column(name="ville", length = 50, nullable = false)
	String ville;
	
	/*@OneToOne(mappedBy = "adresse")
	@JoinColumn(name = "utilisateur_id") 
	private Utilisateur utilisateur;*/
}
