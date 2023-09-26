package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metodi.PagamentoDao;
import model.Pagamento;

@WebServlet("/Pagamento")
public class Paga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		String id = request.getParameter("id");
		PagamentoDao payment = new PagamentoDao();
		
		if(!id.equals("") || id != null)
		{
			System.out.println("id: " + id);
			Integer id_pagamento = Integer.parseInt(id);
			Pagamento toSubstitute = payment.cerca(id_pagamento);
			toSubstitute.setStato("pagato");
			toSubstitute.setCosto_totale(0.0);
			payment.modifica(toSubstitute);
		}
		
		rd = request.getRequestDispatcher("cameriere.jsp");
		rd.forward(request, response);
		
		doGet(request, response);
	}

}
