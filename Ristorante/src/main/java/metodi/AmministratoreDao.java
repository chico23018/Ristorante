package metodi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import connessione.Connessione;
import model.Amministratore;

public class AmministratoreDao {
	
	private Connection con = null;
	
	public void inserire (Amministratore amm) {
		
		String query = "INSERT INTO amministratore( id, nome, cognome, username, password) values(?,?,?,?,?)";

		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1, id);
			pst.setString(2, nome);
			pst.setString(2, nome);
			pst.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		
	}
	public void modifica(Amministratore amm) {
		
	}
	public void elimina(int id_amm) {
		
	}
	public List<Amministratore> dl(){
		return null;
	}

}
