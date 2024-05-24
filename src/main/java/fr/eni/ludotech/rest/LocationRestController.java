package fr.eni.ludotech.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.ludotech.bll.LocationService;
import fr.eni.ludotech.bo.ExemplaireJeu;
import fr.eni.ludotech.dal.ClientRepository;
import fr.eni.ludotech.dal.ExemplaireJeuRepository;

@RestController
public class LocationRestController {
	
	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private ExemplaireJeuRepository exemplaireRepo;

	@Autowired
	private LocationService locationService;

	@GetMapping("/exemplaires")
	public List<ExemplaireJeu> listerExemplaires() {
		
		List<ExemplaireJeu> exemplaires = locationService.listerExemplaires();
		return exemplaires;
	}
	
	@PostMapping("/exemplaires")
	public ExemplaireJeu ajouterExemplaire(@RequestBody ExemplaireJeu exemplaire) {
		locationService.ajouterExemplaire(exemplaire);
		
		return exemplaire;
	}
	
	@DeleteMapping("/exemplaires/{id}")
	public ResponseEntity<ExemplaireJeu> supprimerExemplaire(@PathVariable(value = "id") Integer id) {
		
		Optional<ExemplaireJeu> optEx = exemplaireRepo.findById(id);
		ResponseEntity<ExemplaireJeu> resEx;
		
		if (optEx.isEmpty()) {
			resEx = ResponseEntity.badRequest().build();
		} else {
			locationService.supprimerExemplaire(id);
			resEx = ResponseEntity.status(HttpStatus.OK).body(optEx.get());
		}
		return resEx;	
	}
	
	@PutMapping("/exemplaires/{id}")
	public ExemplaireJeu modifierExemplaire(@PathVariable(value = "id") Integer id, @RequestBody ExemplaireJeu exemplaire) {
		exemplaire = locationService.modifierExemplaire(exemplaire);
		return exemplaire;
		
	}
}
