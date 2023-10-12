package it.eventi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.eventi.entities.PrenotazioneDettaglio;

@Repository
public interface PrenotazioneDettaglioDAO extends JpaRepository<PrenotazioneDettaglio, Integer> {

}
