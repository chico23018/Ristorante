package metodi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		Query query = new Query();
		String totale = "";
		String id_tavolo = "1";
		
		if(id_tavolo!=null) {
			
			ResultSet rs_2 = query.getResult("SELECT costo_totale\n"
					+ "FROM pagamento\n"
					+ "WHERE id_tavolo ='"+id_tavolo+"'\n");
			
			try {
				
				if (rs_2.next()) 
					totale = rs_2.getString("costo_totale");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			Double costo_totale = Double.parseDouble(totale);
			System.out.println("Value: " + costo_totale);
	   }

	}

}
