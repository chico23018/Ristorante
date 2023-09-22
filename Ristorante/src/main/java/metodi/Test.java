package metodi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Test {

	public static void main(String[] args) {
		
		List<Map<String, String>> resultList = new ArrayList<>();
		Query query = new Query();
		String id_tavolo= "5";
		
		ResultSet rs = query.getResult("SELECT p.nome, p.descrizione, ordine.stato, COUNT(*) as amount, p.costo*COUNT(*) as totale\n"
				+ "FROM tavolo\n"
				+ "INNER JOIN ordine ON tavolo.id = ordine.id_tavolo\n"
				+ "INNER JOIN piatto p ON ordine.id_piatto = p.id\n"
				+ "WHERE tavolo.id ='"+id_tavolo+"'\n"
				+ "GROUP BY p.nome, p.descrizione, p.costo, ordine.stato;");
		
		try {

			while (rs.next()) {
			    Map<String, String> map = new HashMap<>();			    
			    map.put("nome", rs.getString(1));
			    map.put("descrizione", rs.getString(2));
			    map.put("costo", rs.getString(3));
			    map.put("quantita", rs.getString(4));
			    resultList.add(map);
			}

			
			  for (Map<String, String> row : resultList) {
			    System.out.println("Nome: " + row.get("nome"));
			    System.out.println("Descrizione: " + row.get("descrizione"));
			    System.out.println("Costo: " + row.get("costo"));
			    System.out.println("Quantità: " + row.get("quantita"));
			    System.out.println("-----------------------------");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
