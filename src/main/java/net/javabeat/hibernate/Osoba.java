package net.javabeat.hibernate;

import java.io.Serializable;
import java.util.List;

/**
 * Model class for Osoba
 */
public class Osoba implements Serializable {
	private Long osobaId;
	private String imie;

	private Adres adres;
	private List<Telefon> telefony;

	public Osoba() {
	}
	
	public List<Telefon> getTelefony() {
        return telefony;
    }

    public void setTelefony(List<Telefon> telefony) {
        this.telefony = telefony;
    }

	public Long getOsobaId() {
		return osobaId;
	}

	public void setOsobaId(Long osobaId) {
		this.osobaId = osobaId;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}
}