package it.eventi.service;

import java.util.List;

import it.eventi.entities.EmailNew;
import it.eventi.entities.EmailNew;

public interface EmailNewService {

	List<EmailNew> getAll();
	EmailNew get(int id);
	EmailNew add(EmailNew e);
	
}
