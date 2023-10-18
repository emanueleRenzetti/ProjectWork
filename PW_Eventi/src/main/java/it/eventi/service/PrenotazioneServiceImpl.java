package it.eventi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eventi.entities.Evento;
import it.eventi.entities.Prenotazione;
import it.eventi.repos.EventoDAO;
import it.eventi.repos.PrenotazioneDAO;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

	@Autowired
	PrenotazioneDAO dao;
	@Autowired
	EventoService eService;
	
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
		Evento e = eService.get(p.getEvento_id());
		p.setPrezzo(e.getPrezzo()*p.getPosti());
		return dao.save(p);
	}

	@Override
    public Prenotazione update(Prenotazione p) {
        // TODO Auto-generated method stub
        Evento e = eService.get(p.getEvento_id());
        p.setPrezzo(e.getPrezzo()*p.getPosti());
        return dao.save(p);
    }

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<Prenotazione> getByUtenteId(int utente_id) {
		// TODO Auto-generated method stub
		return dao.cercaPerUtente(utente_id);
	}

}
