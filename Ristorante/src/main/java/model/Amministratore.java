package model;

public class Amministratore {
	private int id_ammi;
	private String nome;
	private String cognome;
	private String username;
	private String password;

	public Amministratore(int id, String n, String c, String u, String p) {
		this.id_ammi = id;
		this.nome = n;
		this.cognome = c;
		this.username = u;
		this.password = p;
	}

	public Amministratore() {
	}

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
