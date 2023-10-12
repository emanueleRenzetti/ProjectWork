package it.eventi.service;

import java.util.List;

import it.eventi.entities.Utente;

public interface UtenteService {

	List<Utente> getAll();
	Utente get(int id);
}
