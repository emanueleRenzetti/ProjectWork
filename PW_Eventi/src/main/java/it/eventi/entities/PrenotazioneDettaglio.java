package it.eventi.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "prenotazioni_dettaglio")
public class PrenotazioneDettaglio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int eventi_id;
	private int prenotazioni_id;
	private int quantita;
	private double prezzo_totale;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEventi_id() {
		return eventi_id;
	}
	public void setEventi_id(int eventi_id) {
		this.eventi_id = eventi_id;
	}
	public int getPrenotazioni_id() {
		return prenotazioni_id;
	}
	public void setPrenotazioni_id(int prenotazioni_id) {
		this.prenotazioni_id = prenotazioni_id;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public double getPrezzo_totale() {
		return prezzo_totale;
	}
	public void setPrezzo_totale(double prezzo_totale) {
		this.prezzo_totale = prezzo_totale;
	}
	
	
}
