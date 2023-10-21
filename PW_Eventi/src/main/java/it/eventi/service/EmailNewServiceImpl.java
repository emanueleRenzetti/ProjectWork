package it.eventi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eventi.entities.EmailNew;
import it.eventi.repos.EmailNewDAO;

@Service
public class EmailNewServiceImpl implements EmailNewService {
	
	@Autowired
	EmailNewDAO dao;

	@Override
	public List<EmailNew> getAll() {
		return dao.findAll();
	}

	@Override
	public EmailNew get(int id) {
		return dao.findById(id).get();
	}

	@Override
	public EmailNew add(EmailNew e) {
		return dao.save(e);
	}

}
