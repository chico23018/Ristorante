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
import model.Amministratore;
import model.Cameriere;


@WebServlet("/login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("user");
		String password =request.getParameter("password");
		
		System.out.println(username+ " "+ password);
		RequestDispatcher rd= request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		doGet(request, response);
		
		AmministratoreDao ad = new AmministratoreDao();
		CameriereDao cd = new CameriereDao();
		String u, p = "";
					
		List<Amministratore> amm_list = ad.lista();
		List<Cameriere> cam_list = cd.lista();
		
		for(Amministratore a : amm_list)
		{
			u = a.getUsername();
			p = a.getPassword();
			if(u.equals(username) && p.equals(password))
			{
				System.out.println("Hello Amministrator");
				// definire la logica
			}
		}
		
		for(Cameriere c : cam_list)
		{
			u = c.getUsername();
			p = c.getPassword();
			if(u.equals(username) && p.equals(password))
			{
				System.out.println("Hello waiter");
				// definire la logica
			}
		}		

	}

}
