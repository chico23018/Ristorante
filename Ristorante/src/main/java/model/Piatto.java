package model;

public class Piatto {
	private int id_piatto;
	private String nome_piatto;
	private double costo;
	private String descrizione;

	public Piatto(int id, String n, double c, String d) {
		this.id_piatto = id;
		this.nome_piatto = n;
		this.costo = c;
		this.descrizione = d;
	}

	public Piatto() {
	}

	public int getId_piatto() {
		return id_piatto;
	}

	public void setId_piatto(int id_piatto) {
		this.id_piatto = id_piatto;
	}

	public String getNome_piatto() {
		return nome_piatto;
	}
	
	public String getDescrizione_piatto() {
		return descrizione;
	}

	public void setNome_piatto(String nome_piatto) {
		this.nome_piatto = nome_piatto;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
