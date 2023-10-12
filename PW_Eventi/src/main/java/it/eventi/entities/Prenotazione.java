package it.eventi.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prenotazioni")
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate data_evento;
	private LocalTime ora;
	private int posti;
	private int utenti_id;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getData_evento() {
		return data_evento;
	}
	public void setData_evento(LocalDate data_evento) {
		this.data_evento = data_evento;
	}
	public LocalTime getOra() {
		return ora;
	}
	public void setOra(LocalTime ora) {
		this.ora = ora;
	}
	public int getPosti() {
		return posti;
	}
	public void setPosti(int posti) {
		this.posti = posti;
	}
	public int getUtenti_id() {
		return utenti_id;
	}
	public void setUtenti_id(int utenti_id) {
		this.utenti_id = utenti_id;
	}
	
	
	
}
