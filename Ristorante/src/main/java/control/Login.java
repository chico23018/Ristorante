package control;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.http11.upgrade.UpgradeServletOutputStream;

import metodi.ClienteDao;
import metodi.LoginDao;
import metodi.Query;
import metodi.TavoloDao;
import model.Amministratore;
import model.Cameriere;

@WebServlet("/login")
public class Login extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Query query = new Query();
		RequestDispatcher rd = null;
		ClienteDao cli = new ClienteDao();
		List<Map<String, String>> resultList = new ArrayList<>();
		String totale = "";
		String id_tavolo = request.getParameter("id");
		
		if(id_tavolo!=null) {
			
			// Execute query
			ResultSet rs = query.getResult("SELECT p.nome, p.descrizione, ordine.stato, COUNT(*) as amount, p.costo*COUNT(*) as totale\n"
					+ "FROM tavolo\n"
					+ "INNER JOIN ordine ON tavolo.id = ordine.id_tavolo\n"
					+ "INNER JOIN piatto p ON ordine.id_piatto = p.id\n"
					+ "WHERE tavolo.id ='"+id_tavolo+"'\n"
					+ "GROUP BY p.nome, p.descrizione, p.costo, ordine.stato;");
			
			ResultSet rs_2 = query.getResult("SELECT costo_totale\n"
					+ "FROM pagamento\n"
					+ "WHERE id_tavolo ='"+id_tavolo+"'\n");
			
			try {
				
				if (rs_2.next()) 
					totale = rs_2.getString("costo_totale");
				
				while (rs.next()) {
					Map<String, String> map = new HashMap<>();
					map.put("nome", rs.getString(1));
					map.put("descrizione", rs.getString(2));
					map.put("stato", rs.getString(3));
					map.put("quantita", rs.getString(4));
					map.put("costo", rs.getString(5));
					resultList.add(map);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			Integer n_tavolo = Integer.parseInt(id_tavolo);
			Double costo_totale = Double.parseDouble(totale);
			request.setAttribute("cliente", cli.cerca_tavolo(n_tavolo));
			request.setAttribute("n_tavolo", n_tavolo);
			request.setAttribute("resultList", resultList);
			request.setAttribute("totale", costo_totale);
			
			rd = request.getRequestDispatcher("tavolo.jsp");
			rd.forward(request, response);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		LoginDao dao = new LoginDao();
		String username = request.getParameter("user");
		String password = request.getParameter("password");

		if (dao.amministratore(username, password) != null) 
		{
			Amministratore m = dao.amministratore(username, password);
			request.setAttribute("nome", m.getNome());
			request.setAttribute("cognome", m.getCognome());
			rd = request.getRequestDispatcher("amministratore.jsp");
			rd.forward(request, response);
		} 
		else if (dao.cameriere(username, password) != null) 
		{
			Cameriere cam = dao.cameriere(username, password);
			TavoloDao daoT = new TavoloDao();
			request.setAttribute("list", daoT.lista());
			request.setAttribute("nome", cam.getNome());
			request.setAttribute("cognome", cam.getCognome());

			rd = request.getRequestDispatcher("/cameriere.jsp");
			rd.forward(request, response);
		}
		else
		{	

			RequestDispatcher rd3 = request.getRequestDispatcher("index.jsp");
			String messaggio = "username e password non sono presenti";
			request.setAttribute("messaggio", messaggio);
			rd3.forward(request, response);
		}

		doGet(request, response);
	}

}

