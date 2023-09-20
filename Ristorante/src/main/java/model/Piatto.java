package model;

public class Piatto {
	private int id_piatto;
	private String nome_piatto;
	private double costo;

	public int getId_piatto() {
		return id_piatto;
	}

	public void setId_piatto(int id_piatto) {
		this.id_piatto = id_piatto;
	}

	public String getNome_piatto() {
		return nome_piatto;
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

}
