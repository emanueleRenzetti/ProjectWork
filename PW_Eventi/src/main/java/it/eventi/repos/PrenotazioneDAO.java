package it.eventi.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.eventi.entities.Prenotazione;

@Repository
public interface PrenotazioneDAO extends JpaRepository<Prenotazione, Integer> {
	
	@Query(value = "select * from prenotazioni where utenti_id = ?", nativeQuery = true)
	List<Prenotazione> cercaPerUtente(int utente_id);

	@Query(value = "select * from prenotazioni where evento_id = ?", nativeQuery = true)
	List<Prenotazione> cercaPerEvento(int evento_id);
}
