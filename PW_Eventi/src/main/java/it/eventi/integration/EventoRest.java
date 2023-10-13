package it.eventi.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.eventi.entities.Evento;
import it.eventi.entities.Prenotazione;
import it.eventi.service.EventoService;

@RestController
@RequestMapping("api")
public class EventoRest {

	@Autowired
	EventoService service;
	
	@GetMapping("eventi")
	List<Evento> getEvento(){
		return service.getAll();
	}
	
	@GetMapping("eventi/{id}")
	Evento get(int id){
		return service.get(id);
	}
	
	@PostMapping("eventi")
	Evento add(Evento e) {
		return service.add(e);
	}
}
