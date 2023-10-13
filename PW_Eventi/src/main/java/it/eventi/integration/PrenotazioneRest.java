package it.eventi.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.eventi.entities.Prenotazione;
import it.eventi.service.PrenotazioneService;

@RestController
@RequestMapping("p")
public class PrenotazioneRest {

	@Autowired
	PrenotazioneService service;
	
	@GetMapping("prenotazioni")
	List<Prenotazione> getPrenotazione(){
		return service.getAll();
	}
	
	@GetMapping("prenotazioni/{id}")
	Prenotazione get(int id){
		return service.get(id);
	}
	
	@PostMapping("prenotazioni")
	Prenotazione add(Prenotazione p) {
		return service.add(p);
	}
}
