package it.eventi.service;

import java.util.List;

import it.eventi.entities.Evento;

public interface EventoService {

	List<Evento> getAll();
	Evento get(int id);
	Evento add(Evento e);
	Evento update(Evento e);
	void delete(int id);
}
