package control;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metodi.OrdineDao;
import metodi.PagamentoDao;
import model.Pagamento;
import metodi.TavoloDao;

@WebServlet("/Pagamento")
public class Paga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		String id = request.getParameter("id");
		String ordine = request.getParameter("ordine");
		OrdineDao order = new OrdineDao();
		PagamentoDao payment = new PagamentoDao();
		
		if(!id.equals("") || id != null)
		{
			Integer id_pagamento = Integer.parseInt(id);
			Pagamento toSubstitute = payment.cerca(id_pagamento);
			toSubstitute.setStato("pagato");
			toSubstitute.setCosto_totale(new BigDecimal("0.00"));
			payment.modifica(toSubstitute);
		}
		else if(ordine.equals("ordine"))
		{
			String id_ord = request.getParameter("id_ordine");
			if(id_ord != null)
			{
				int id_ordine = Integer.parseInt(id_ord);
				order.elimina(id_ordine);
				System.out.println("Ordine eliminato");
			}
		}
		
		TavoloDao daoT = new TavoloDao();
		request.getSession().setAttribute("list", daoT.lista());
		rd = request.getRequestDispatcher("cameriere.jsp");
		rd.forward(request, response);
		
		doGet(request, response);
	}

}
