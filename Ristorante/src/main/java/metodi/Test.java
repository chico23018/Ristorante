package metodi;

import java.math.BigDecimal;
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
			
			ResultSet rs3=query.getResult("select sum(costo) from piatto inner join ordine on piatto.id = id_piatto where id_tavolo='1'");
			
			try {
				
				if(rs3.next()) {
				BigDecimal di = rs3.getBigDecimal(1);
					System.out.println(di + " 74");}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
	   }

	}

}
