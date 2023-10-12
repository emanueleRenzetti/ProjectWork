package it.eventi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eventi.entities.Utente;
import it.eventi.repos.UtenteDAO;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	UtenteDAO dao;
	
	@Override
	public List<Utente> getAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Utente get(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

}
