package model;

public class Pagamento {
	private int id_tavolo;
	private double costo_totale;
	private String stato;
	private String data;

	public int getId_tavolo() {
		return id_tavolo;
	}

	public void setId_tavolo(int id_tavolo) {
		this.id_tavolo = id_tavolo;
	}

	public double getCosto_totale() {
		return costo_totale;
	}

	public void setCosto_totale(double costo_totale) {
		this.costo_totale = costo_totale;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
