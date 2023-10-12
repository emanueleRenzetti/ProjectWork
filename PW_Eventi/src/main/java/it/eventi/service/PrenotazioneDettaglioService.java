package it.eventi.service;

import java.util.List;

import it.eventi.entities.PrenotazioneDettaglio;

public interface PrenotazioneDettaglioService {

	List<PrenotazioneDettaglio> getAll();
	PrenotazioneDettaglio get(int id);
	PrenotazioneDettaglio add(PrenotazioneDettaglio pd);
	PrenotazioneDettaglio update(PrenotazioneDettaglio pd);
	void delete(int id);
}
