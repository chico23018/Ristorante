package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metodi.ClienteDao;
import metodi.TavoloDao;
import model.Cliente;
import model.Tavolo;


@WebServlet("/Prenota")
public class Prenota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TavoloDao tav = new TavoloDao();
		List<Tavolo> tavoli_liberi = new ArrayList<>();
		RequestDispatcher rd = null;
		
		for(Tavolo t : tav.lista())
		{
			if(t.getStato().equals("libero"))
			{
				tavoli_liberi.add(t);
			}
		}
		
		request.setAttribute("tavoli_liberi", tavoli_liberi);
		rd = request.getRequestDispatcher("prenotazione.jsp");
		rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		Integer id_tavolo = Integer.parseInt(request.getParameter("id_tavolo"));
		ClienteDao cl = new ClienteDao();
	
		String esito = cl.inserire(new Cliente(0, nome, cognome, id_tavolo));
		if(esito.equals("SUCCESS"))
			
		{			//	rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("esito", esito);
			//rd.forward(request, response);
		}else
		{
			rd = request.getRequestDispatcher("prenotazione.jsp");
			request.setAttribute("esito", esito);
			rd.forward(request, response);
		}
		doGet(request, response);
	}

}
