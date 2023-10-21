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

import it.eventi.entities.EmailNew;
import it.eventi.service.EmailNewService;
import it.eventi.service.EventoService;

@RestController
@RequestMapping("em")
@CrossOrigin
public class EmailNewRest {

	@Autowired
	EmailNewService service;
	
	@GetMapping("email")
	List<EmailNew> getEmails(){
		return service.getAll();
	}
	
	@GetMapping("email/{id}")
	EmailNew get(@PathVariable int id){
		return service.get(id);
	}
	
	@PostMapping("email")
	EmailNew add(@RequestBody EmailNew e) {
		return service.add(e);
	}
	
	
}
