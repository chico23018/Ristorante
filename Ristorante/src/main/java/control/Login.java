package control;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String id_tavolo = request.getParameter("id");
		ClienteDao cli = new ClienteDao();
		List<Map<String, String>> resultList = new ArrayList<>();
		
		if(id_tavolo!=null) {
			
			// Execute query
			ResultSet rs = query.getResult("SELECT p.nome, p.descrizione, p.costo, COUNT(*) as quantita\n"
					+ "FROM tavolo\n"
					+ "INNER JOIN ordine ON tavolo.id ='"+id_tavolo+"'\n"
					+ "INNER JOIN piatto p ON ordine.id_piatto = p.id\n"
					+ "GROUP BY p.nome, p.descrizione, p.costo;");
			
			try {

				while (rs.next()) {
				    Map<String, String> map = new HashMap<>();
				    map.put("nome", rs.getString(1));
				    map.put("descrizione", rs.getString(2));
				    map.put("costo", rs.getString(3));
				    map.put("quantita", rs.getString(4));
				    resultList.add(map);
				}

				/*
				 * for (Map<String, String> row : resultList) {
				    System.out.println("Nome: " + row.get("nome"));
				    System.out.println("Descrizione: " + row.get("descrizione"));
				    System.out.println("Costo: " + row.get("costo"));
				    System.out.println("Quantità: " + row.get("quantita"));
				    System.out.println("-----------------------------");
				}
				*/
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			Integer n_tavolo = Integer.parseInt(id_tavolo);
			request.setAttribute("cliente", cli.cerca_tavolo(n_tavolo));
			request.setAttribute("n_tavolo", n_tavolo);
			request.setAttribute("resultList", resultList);
			
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

