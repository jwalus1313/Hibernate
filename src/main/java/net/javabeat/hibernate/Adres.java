package net.javabeat.hibernate;

import java.io.Serializable;

public class Adres implements Serializable {
	private String ulica;
	private Osoba osoba;
	private Long osobaId;

	public Adres() {

	}

	public Adres(String ulica) {
		this.ulica = ulica;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public Osoba getOsoba() {
		return osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

	public Long getOsobaId() {
		return osobaId;
	}

	public void setOsobaId(Long osobaId) {
		this.osobaId = osobaId;
	}

}
