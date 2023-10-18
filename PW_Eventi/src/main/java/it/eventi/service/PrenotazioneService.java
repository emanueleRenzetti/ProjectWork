package it.eventi.service;

import java.util.List;

import it.eventi.entities.Prenotazione;

public interface PrenotazioneService {

	List<Prenotazione> getAll();
	Prenotazione get(int id);
	Prenotazione add(Prenotazione p);
	Prenotazione updatePosti(Prenotazione p);
	void delete(int id);
	List<Prenotazione> getByUtenteId(int utente_id);
}
