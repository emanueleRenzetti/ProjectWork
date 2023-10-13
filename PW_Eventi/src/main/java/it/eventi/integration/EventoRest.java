package it.eventi.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.eventi.entities.Evento;
import it.eventi.entities.Prenotazione;
import it.eventi.service.EventoService;

@RestController
@RequestMapping("e")
@CrossOrigin
public class EventoRest {

	@Autowired
	EventoService service;
	
	@GetMapping("eventi")
	List<Evento> getEvento(){
		return service.getAll();
	}
	
	@GetMapping("eventi/{id}")
	Evento get(@PathVariable int id){
		return service.get(id);
	}
	
	@PostMapping("eventi")
	Evento add(Evento e) {
		return service.add(e);
	}
}
