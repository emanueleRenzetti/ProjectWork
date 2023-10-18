package it.eventi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eventi.entities.Prenotazione;
import it.eventi.repos.PrenotazioneDAO;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

	@Autowired
	PrenotazioneDAO dao;
	
	@Override
	public List<Prenotazione> getAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Prenotazione get(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public Prenotazione add(Prenotazione p) {
		// TODO Auto-generated method stub
		return dao.save(p);
	}

	//@Override
	//public Prenotazione updatePosti(Prenotazione p) {
		// TODO Auto-generated method stub
		//dao.findById(id).get().setPosti(p.getPosti());
		//return dao.;
	//}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public Prenotazione updatePosti(Prenotazione p) {
		// TODO Auto-generated method stub
		return null;
	}

}
