package fr.eni.ludotech.dto;

import java.util.HashSet;
import java.util.Set;

import fr.eni.ludotech.dto.LocationDTO;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
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
