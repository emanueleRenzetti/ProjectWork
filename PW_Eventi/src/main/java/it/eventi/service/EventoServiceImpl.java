package it.eventi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eventi.entities.Evento;
import it.eventi.repos.EventoDAO;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	EventoDAO dao;
	
	@Override
	public List<Evento> getAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Evento get(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public Evento add(Evento e) {
		// TODO Auto-generated method stub
		return dao.save(e);
	}

	@Override
	public Evento update(Evento e) {
		// TODO Auto-generated method stub
		return dao.save(e);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		 dao.deleteById(id);
	}

}
