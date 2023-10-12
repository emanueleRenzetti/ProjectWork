package it.eventi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.eventi.entities.Evento;

@Repository
public interface EventoDAO extends JpaRepository<Evento, Integer> {

}
