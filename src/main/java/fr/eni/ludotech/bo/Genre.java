package fr.eni.ludotech.bo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name="GENRE")
public class Genre {
	
	@Id
	@GeneratedValue()
	private Integer id;
	
	@Column(name="libelle")
	private String libelle;
	
	@ManyToMany(mappedBy="genres")
    private List<ModeleJeu> modeles_jeux;

}
