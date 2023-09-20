package metodi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connessione.Connessione;
import model.Pagamento;

public class PagamentoDao {
	
	
	private Connection con = null;

public void inserire (Pagamento pag) {
		
	String query = "INSERT INTO pagamento( costo_totale, stato, data) values(?,?,?)";
	try {
		con = Connessione.getInstance().getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setDouble(1, pag.getCosto_totale());
		pst.setString(2,pag.getStato());
		pst.setString(3,pag.getData());
		pst.executeUpdate();
	} catch (SQLException | ClassNotFoundException e) {
		System.out.println(e.getMessage());
	}

	
	}
	public void modifica(Pagamento pag) {
		
		String query = "UPDATE pagamento SET  costo_totale = ?, stato = ?, data = ? WHERE id_pagamento ='"
				+ pag.getId_pagamento() + "'";
		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setDouble(1, pag.getCosto_totale());
			pst.setString(2,pag.getStato());
			pst.setString(3, pag.getData());
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void elimina(int id_pag) {
		
		String query = "DELETE FROM pagamento WHERE id ='" + id_pag+ "'";

		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public List<Pagamento> lista(){
		
		String query = "SELECT * FROM pagamento";
		List<Pagamento> list = new ArrayList<Pagamento>();
        try {
            con = Connessione.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rst=  pst.executeQuery();
             while (rst.next()) {
            	 Pagamento p = new Pagamento();
 				p.setId_pagamento(rst.getInt(1));
            	 p.setId_tavolo(rst.getInt(2));
            	 p.setCosto_totale(rst.getDouble(3));
            	 p.setStato(rst.getString(4));
            	 p.setData(rst.getString(5));
 				list.add(p);
			}
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return list;
		
	}
	
	
	public Pagamento cerca(int id) {
		
		String query = "SELECT * FROM pagamento where id ='" + id + "'";
		Pagamento pag = null;
		try {
			con = Connessione.getInstance().getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			rs.next();

			pag = new Pagamento(
					rs.getInt("id"),
					rs.getInt("id_tavolo"),
					rs.getDouble("costo_totale"),
					rs.getString("stato"),
					rs.getString("data"));

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return pag;
	}
	}
	
