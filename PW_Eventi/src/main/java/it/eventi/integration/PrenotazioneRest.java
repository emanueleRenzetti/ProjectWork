package it.eventi.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.eventi.entities.Prenotazione;
import it.eventi.service.PrenotazioneService;

@RestController
@RequestMapping("p")
@CrossOrigin
public class PrenotazioneRest {

	@Autowired
	PrenotazioneService service;
	
	@GetMapping("prenotazioni")
	List<Prenotazione> getPrenotazione(){
		return service.getAll();
	}
	
	@GetMapping("prenotazioni/{id}")
	Prenotazione get(@PathVariable int id){
		return service.get(id);
	}
	
	@PostMapping("prenotazioni")
	Prenotazione add(@RequestBody Prenotazione p) {
		return service.add(p);
	}
	
	@PutMapping("prenotazioni")
	Prenotazione update(@RequestBody Prenotazione p) {
		return service.update(p);
	}
	
	@GetMapping("prenotazioni/utente/{id}")
	List<Prenotazione> getByUtenteId(@PathVariable int id){
		return service.getByUtenteId(id);
	}
	
	@DeleteMapping("prenotazioni/{id}")
	void delete(@PathVariable int id) {
			service.delete(id);
	}
	
}
