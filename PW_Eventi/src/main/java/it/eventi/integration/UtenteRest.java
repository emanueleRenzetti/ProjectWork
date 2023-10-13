package it.eventi.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.eventi.entities.Utente;
import it.eventi.service.UtenteService;

@RestController
@RequestMapping("u")
@CrossOrigin
public class UtenteRest {

	@Autowired
	UtenteService service;
	
	@GetMapping("utenti")
	List<Utente> getEvento(){
		return service.getAll();
	}
	
	@GetMapping("utenti/{id}")
	Utente get(int id) {
		return service.get(id);
	}
}
