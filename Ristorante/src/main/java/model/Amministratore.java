package model;

public class Amministratore {
	private int id_ammi;
	private String nome;
	private String cognome;
	private String username;
	private String password;

	public int getId_ammi() {
		return id_ammi;
	}

	public void setId_ammi(int id_ammi) {
		this.id_ammi = id_ammi;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
