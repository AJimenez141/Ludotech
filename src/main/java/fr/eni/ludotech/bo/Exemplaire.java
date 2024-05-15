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
@Table(name="EXEMPLAIRE")
public class Exemplaire {
	
	@Id
	@GeneratedValue()
	private Integer id;
	
	@Column(name="code_barre", length = 15, nullable = false)
	private String code_barre;
	
	@Column(name="est_louable", nullable = false)
	@Builder.Default Boolean est_louable = true;

}
