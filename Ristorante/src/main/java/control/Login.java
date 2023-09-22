package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metodi.ClienteDao;
import metodi.LoginDao;
import metodi.TavoloDao;
import model.Amministratore;
import model.Cameriere;

@WebServlet("/login")
public class Login extends HttpServlet {

	RequestDispatcher rd = null;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer n_tavolo = Integer.parseInt(request.getParameter("id_tavolo"));
		ClienteDao cli = new ClienteDao();
		request.setAttribute("cliente", cli.cerca_tavolo(n_tavolo));
		request.setAttribute("n_tavolo", n_tavolo);
		
		rd = request.getRequestDispatcher("tavolo.jsp");
		rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

			rd = request.getRequestDispatcher("cameriere.jsp");
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
