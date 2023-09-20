package metodi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connessione.Connessione;
import model.Amministratore;

public class AmministratoreDao {

	
	private Connection con = null;
	

	public void inserire(Amministratore amm) {
		String query = "INSERT INTO amministratore( nome, cognome, username, password) values(?,?,?,?)";
		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, amm.getNome());
			pst.setString(2, amm.getCognome());
			pst.setString(3, amm.getUsername());
			pst.setString(4, amm.getPassword());
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}


	}

	public void modifica(Amministratore amm) {
		String query = "UPDATE amministratore SET nome = ?, cognome = ?, username = ?, password = ? WHERE id ='"
				+ amm.getId_ammi() + "'";
		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, amm.getNome());
			pst.setString(2, amm.getCognome());
			pst.setString(3, amm.getUsername());
			pst.setString(4, amm.getPassword());
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}

	public void elimina(int id_amm) {
		String query = "DELETE FROM amministratore WHERE id ='" + id_amm + "'";

		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Amministratore> lista() {
		String query = "SELECT * FROM amministratore";
		List<Amministratore> list = new ArrayList<Amministratore>();
        try {
            con = Connessione.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rst=  pst.executeQuery();
             while (rst.next()) {
            	 Amministratore n = new Amministratore();
 				n.setId_ammi(rst.getInt(1));
 				n.setNome(rst.getString(2));
 				n.setCognome(rst.getString(3));
 				n.setUsername(rst.getString(4));
 				n.setPassword(rst.getString(5));
 				list.add(n);
			}
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return list;
	}

	public Amministratore cerca(int id) {
		String query = "SELECT * FROM amministratore where id ='"+id+"'";
		 Amministratore n = new Amministratore();
        try {
            con = Connessione.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rst=  pst.executeQuery();
             rst.next();
            	
 				n.setId_ammi(rst.getInt(1));
 				n.setNome(rst.getString(2));
 				n.setCognome(query);
 				n.setUsername(query);
 				n.setPassword(query);
 				
			
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
		return n;
		
	}

}
