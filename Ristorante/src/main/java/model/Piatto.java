package model;

public class Piatto {
	private int id_piatto;
	private String nome_piatto;
	private float costo;
	private String descrizione;
	private String tipo;

	public Piatto(int id, String n, float c, String descrizione, String tipo) {
		this.id_piatto = id;
		this.nome_piatto = n;
		this.costo = c;
		this.descrizione = descrizione;
		this.tipo = tipo;
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

	public void setNome_piatto(String nome_piatto) {
		this.nome_piatto = nome_piatto;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "Piatto [id_piatto=" + id_piatto + ", nome_piatto=" + nome_piatto + ", costo=" + costo + ", descrizione="
				+ descrizione + "]";
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
