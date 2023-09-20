package metodi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Ordine;
import connessione.Connessione;
import model.Amministratore;
import model.Cameriere;
import model.Piatto;

public class PiattoDao {

	
	private Connection con = null;
	
	public void inserire (Piatto piatto) {
		String query = "INSERT INTO piatto(nome, costo, descrizione) values(?,?,?)";
		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, piatto.getNome_piatto());
			pst.setDouble(2, piatto.getCosto());
			pst.setString(3, piatto.getDescrizione_piatto());
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void modifica(Piatto piatto) {
		String query = "UPDATE piatto SET nome=?, costo=?, descrizione=? WHERE id='"+piatto.getId_piatto()+"'";
		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, piatto.getNome_piatto());
			pst.setDouble(2, piatto.getCosto());
			pst.setString(3, piatto.getDescrizione_piatto());
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	public void elimina(int id_piatto) {
		
		String query = "DELETE FROM piatto WHERE id ='" + id_piatto + "'";

		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Piatto> lista_piatti(){
		String query = "SELECT * FROM piatto";
		List<Piatto> list = new ArrayList<>();
        try {
            con = Connessione.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs=  pst.executeQuery();
             while (rs.next()) {
            	Piatto p = new Piatto(
            			rs.getInt("id"),
            			rs.getString("nome"),
            			rs.getDouble("costo"),
            			rs.getString("descrizione"));
 				list.add(p);
			}
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return list;	
	}
	
	public Piatto cerca(int id_piatto) {
		String query = "SELECT * FROM piatto where id ='"+id_piatto+"'";
        Piatto p = null;
        try {
            con = Connessione.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs=  pst.executeQuery();
            rs.next();
			p = new Piatto(
					rs.getInt("id"),
        			rs.getString("nome"),
        			rs.getDouble("costo"),
        			rs.getString("descrizione"));
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return p;
	}
	
}