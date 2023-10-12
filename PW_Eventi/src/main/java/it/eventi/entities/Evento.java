package it.eventi.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "eventi")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tipologia;
	private String caratteristiche;
	private String descrizione;
	private String luogo_evento;
	private double prezzo;
	private int disponibilita;
	private LocalDate data_evento;
	private String locandina;
	private int utenti_id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getCaratteristiche() {
		return caratteristiche;
	}
	public void setCaratteristiche(String caratteristiche) {
		this.caratteristiche = caratteristiche;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getLuogo_evento() {
		return luogo_evento;
	}
	public void setLuogo_evento(String luogo_evento) {
		this.luogo_evento = luogo_evento;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}
	public LocalDate getData_evento() {
		return data_evento;
	}
	public void setData_evento(LocalDate data_evento) {
		this.data_evento = data_evento;
	}
	public String getLocandina() {
		return locandina;
	}
	public void setLocandina(String locandina) {
		this.locandina = locandina;
	}
	public int getUtenti_id() {
		return utenti_id;
	}
	public void setUtenti_id(int utenti_id) {
		this.utenti_id = utenti_id;
	}
	
	
	
}
