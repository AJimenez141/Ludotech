package fr.eni.ludotech.rest;

import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.eni.ludotech.bll.LocationService;
import fr.eni.ludotech.bo.Client;
import fr.eni.ludotech.bo.ExemplaireJeu;
import fr.eni.ludotech.bo.Location;
import fr.eni.ludotech.bo.ModeleJeu;
import fr.eni.ludotech.dal.ClientRepository;
import fr.eni.ludotech.dal.ExemplaireJeuRepository;
import fr.eni.ludotech.dto.LocationDTO;

@RestController
public class TestLocationRestController {

	@Autowired
	private ClientRepository clientRepo;

	@Autowired
	private ExemplaireJeuRepository exemplaireRepo;

	@Autowired
	private LocationService locationService;
	
	
	@GetMapping("/testModelesJeuxDisponibles")
	public List<ModeleJeu> testModelesJeuxDisponibles(){
		return locationService.modeleJeuxDisponibles();
	}

	@GetMapping("/testReserverModeleJeu")
	public void testReserverModeleJeu(@RequestParam("idModeleJeu") Integer idModeleJeu){
		Client john = clientRepo.findByTelephone("04040404");
		locationService.reserverModeleJeu(john, ModeleJeu.builder().id(idModeleJeu).build());
	}

	
	@GetMapping("/testCreerLocation")
	public Location creerLocation() {
		
			List<Client> clients = clientRepo.findAll();
						
			ExemplaireJeu jeu1 = exemplaireRepo.findByCodeBarre("111");
			ExemplaireJeu jeu2 = exemplaireRepo.findByCodeBarre("222");
			
			Client client1 = clientRepo.findByTelephone("01010101");
			
			LocationDTO demandeLocation = LocationDTO.builder()
					.clientId(client1.getId())
					.build();
			demandeLocation.initJeuxIds(jeu1.getId(), jeu2.getId());
			
			Location nouvelleLocation = locationService.louerExemplaires(demandeLocation);
			System.out.println("Nouvelle location : ");
			System.out.println(nouvelleLocation);
			return nouvelleLocation;
		}

	@GetMapping("/testJeuNonDisponible")
	public void testJeuNonDisponible() {
			ExemplaireJeu jeu1 = exemplaireRepo.findByCodeBarre("111");
			ExemplaireJeu jeu2 = exemplaireRepo.findByCodeBarre("222");
			ExemplaireJeu jeu3 = exemplaireRepo.findByCodeBarre("333");
			ExemplaireJeu jeu4 = exemplaireRepo.findByCodeBarre("444");

			List<ExemplaireJeu> jeuxNonDispo = 
					exemplaireRepo.findExemplairesJeuxNonDisponible(Arrays.asList(jeu1.getId(), jeu2.getId(), jeu3.getId(), jeu4.getId()));
			
			System.out.println("Jeux non disponibles : " );
			System.out.println(jeuxNonDispo.toString());
			
	}
	
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
