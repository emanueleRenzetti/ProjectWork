package it.eventi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eventi.entities.PrenotazioneDettaglio;
import it.eventi.repos.PrenotazioneDettaglioDAO;

@Service
public class PrenotazioneDettaglioServiceImpl implements PrenotazioneDettaglioService {

	@Autowired
	PrenotazioneDettaglioDAO dao;
	
	@Override
	public List<PrenotazioneDettaglio> getAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public PrenotazioneDettaglio get(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public PrenotazioneDettaglio add(PrenotazioneDettaglio pd) {
		// TODO Auto-generated method stub
		return dao.save(pd);
	}

	@Override
	public PrenotazioneDettaglio update(PrenotazioneDettaglio pd) {
		// TODO Auto-generated method stub
		return dao.save(pd);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
