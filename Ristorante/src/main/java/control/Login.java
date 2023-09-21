package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metodi.AmministratoreDao;
import metodi.CameriereDao;
import metodi.LoginDao;
import metodi.TavoloDao;
import model.Amministratore;
import model.Cameriere;

@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Output: "+request.getParameter("id"));
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LoginDao dao = new LoginDao();
		RequestDispatcher rd = null;
		String username = request.getParameter("user");
		String password = request.getParameter("password");

		if (dao.amministratore(username, password) != null) 
		{
			Amministratore m = dao.amministratore(username, password);
			System.out.println("Hello Amministrator");
			request.setAttribute("nome", m.getNome());
			request.setAttribute("cognome", m.getCognome());
			rd = request.getRequestDispatcher("Amministratore.jsp");
			rd.forward(request, response);
		} 
		else if (dao.cameriere(username, password) != null) 
		{
			Cameriere cam = dao.cameriere(username, password);
			System.out.println("Hello waiter");
			TavoloDao daoT = new TavoloDao();
			request.setAttribute("list", daoT.lista());
			request.setAttribute("nome", cam.getNome());
			request.setAttribute("cognome", cam.getCognome());
			
			rd = request.getRequestDispatcher("Cameriere.jsp");
			rd.forward(request, response);
		}
		else
		{	
			System.out.println("null");
			RequestDispatcher rd3 = request.getRequestDispatcher("index.jsp");
			String messaggio = "username e password non sono presenti";
			request.setAttribute("messaggio", messaggio);
			rd3.forward(request, response);
		}

		doGet(request, response);
	}

}
