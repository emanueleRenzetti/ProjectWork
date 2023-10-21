package it.eventi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.eventi.entities.EmailNew;


@Repository
public interface EmailNewDAO extends JpaRepository<EmailNew, Integer> {

}
