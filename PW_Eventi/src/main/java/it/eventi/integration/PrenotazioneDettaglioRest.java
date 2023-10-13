package it.eventi.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.eventi.entities.PrenotazioneDettaglio;
import it.eventi.service.PrenotazioneDettaglioService;

@RestController
@RequestMapping("pd")
@CrossOrigin
public class PrenotazioneDettaglioRest {

	@Autowired
	PrenotazioneDettaglioService service;
	
	@GetMapping("prenotazioni_dettaglio")
	List<PrenotazioneDettaglio> getPrenotazioneDettaglio(){
		return service.getAll();
	}
	
	@GetMapping("prenotazioni_dettaglio/{id}")
	PrenotazioneDettaglio get(@PathVariable  int id) {
		return service.get(id);
	}
	
	@PostMapping("prenotazioni_dettaglio")
	PrenotazioneDettaglio add(PrenotazioneDettaglio pd) {
		return service.add(pd);
	}
}
