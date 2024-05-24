package fr.eni.ludotech.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fr.eni.ludotech.bo.Client;
import fr.eni.ludotech.bo.LocationExemplaire;
import fr.eni.ludotech.dto.LocationDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationDTO {	 
	 
	@Builder.Default 
	private Set<Integer> jeuxIds = new HashSet<Integer>();
	private Integer clientId;

	public void initJeuxIds(Integer... idsJeu ) {
		jeuxIds = new HashSet<Integer>();
		for(Integer idJeu: idsJeu) {
			jeuxIds.add(idJeu);
		}
	}
}
