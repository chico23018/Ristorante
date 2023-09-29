package control;

import java.io.IOException;
import java.math.BigDecimal;
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

import metodi.OrdineDao;
import metodi.PagamentoDao;
import metodi.Query;
import model.Pagamento;
import metodi.TavoloDao;

@WebServlet("/Pagamento")
public class Paga extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		Query query = new Query();
		String id = request.getParameter("id");
		String ordine = request.getParameter("ordine");
		OrdineDao order = new OrdineDao();
		PagamentoDao payment = new PagamentoDao();
		List<Map<String, String>> resultList = new ArrayList<>();
		String totale = "", id_p ="", cognome ="";

		if (id != null) {
			Integer id_pagamento = Integer.parseInt(id);
			Pagamento toSubstitute = payment.cerca(id_pagamento);
			toSubstitute.setStato("pagato");
			toSubstitute.setCosto_totale(new BigDecimal("0.00"));
			payment.modifica(toSubstitute);
			TavoloDao daoT = new TavoloDao();

			request.getSession().setAttribute("list", daoT.lista());
			rd = request.getRequestDispatcher("cameriere.jsp");
			rd.forward(request, response);
		 
		}

		doGet(request, response);
	}

}
