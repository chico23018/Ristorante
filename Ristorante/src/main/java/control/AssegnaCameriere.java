package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metodi.TavoloDao;
import model.Tavolo;


@WebServlet("/assegna")
public class AssegnaCameriere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		TavoloDao td = new TavoloDao();
		
		String idCameriere=request.getParameter("id_cameriere");
		String idTavolo=request.getParameter("id_tavolo");
		if(idCameriere!=null&&idTavolo!=null) {
			
			
			int id_cameriere=Integer.parseInt(idCameriere);
			int id_tavolo=Integer.parseInt(idTavolo);
			Tavolo t=td.cerca(id_tavolo);
			t.setId_camerie(id_cameriere);
			td.modifica(t);
			rd = request.getRequestDispatcher("cameriere.jsp");
			rd.forward(request, response);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
