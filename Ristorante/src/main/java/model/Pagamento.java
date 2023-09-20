package model;

public class Pagamento {
	private int id_pagamento;
	private int id_tavolo;
	private double costo_totale;
	private String stato;
	private String data;

	public Pagamento(int id,int id_tavolo, double ct, String s, String d) {
		this.id_pagamento=id;
		this.id_tavolo = id_tavolo;
		this.costo_totale = ct;
		this.stato = s;
		this.data = d;
	}

	public int getId_pagamento() {
		return id_pagamento;
	}

	public void setId_pagamento(int id_pagamento) {
		this.id_pagamento = id_pagamento;
	}

	public Pagamento() {
	}

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
