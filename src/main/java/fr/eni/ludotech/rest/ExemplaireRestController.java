package fr.eni.ludotech.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.ludotech.bll.LocationService;
import fr.eni.ludotech.bo.ExemplaireJeu;
import fr.eni.ludotech.bo.ModeleJeu;
import fr.eni.ludotech.dal.ClientRepository;
import fr.eni.ludotech.dal.ExemplaireJeuRepository;

@RestController
public class ExemplaireRestController {
	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private ExemplaireJeuRepository exemplaireRepo;

	@Autowired
	private LocationService locationService;
	
	@GetMapping("/modeles")
	public List<ModeleJeu> listerModelesDisponibles() {
		List<ModeleJeu> modeles = locationService.listerModelesDisponibles();
		return modeles;
	}
	
	@PutMapping("/exemplaires/reserver/{id}")
	public ExemplaireJeu modifierExemplaire(@PathVariable(value = "id") Integer id, @RequestBody ExemplaireJeu exemplaire) {
		exemplaire = locationService.modifierExemplaire(exemplaire);
		return exemplaire;
		
	}
}
