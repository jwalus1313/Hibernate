package net.javabeat.hibernate;

import java.io.Serializable;

public class Telefon implements Serializable {
	private Long id;
	private String numer;
	private String operator;
	private Osoba osoba;
	
	public Telefon(){
		
	}
	
	public Osoba getOsoba() {
		return osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}
	
	public Telefon(String numer, Osoba osoba, String operator){
		this.numer = numer;
		this.osoba = osoba;
		this.operator = operator;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getnumer() {
		return numer;
	}

	public void setnumer(String numer) {
		this.numer = numer;
	}
	
	public String getoperator() {
		return operator;
	}

	public void setoperator(String operator) {
		this.operator = operator;
	}
}
