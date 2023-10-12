package it.eventi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.eventi.entities.Utente;

@Repository
public interface UtenteDAO extends JpaRepository<Utente, Integer> {

}
