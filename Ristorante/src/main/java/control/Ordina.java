package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import metodi.PiattoDao;
import model.Ordine;
import model.Piatto;


@WebServlet("/Ordina")
public class Ordina extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =request.getParameter("id_tavolo");
		PiattoDao pd = new PiattoDao();
		RequestDispatcher rd = null;
		if(id!=null) {
		request.setAttribute("id_tavolo", id);	
		}
		request.getSession().setAttribute("lista_piatti", pd.lista());
		
		rd = request.getRequestDispatcher("ordine.jsp");
		rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String id =request.getParameter("id_tavolo");
		 // Leggi i dati JSON dalla richiesta
        BufferedReader reader = request.getReader();
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
            System.out.println(line);
            
        }

        // Converti i dati JSON in un array Java
        Gson gson = new Gson();
       /* Type tipoLista = new TypeToken<List<Piatto>>() {}.getType();
        List<Piatto> ordini = gson.fromJson(requestBody.toString(), tipoLista);*/
        Type tipoLista = new TypeToken<List<Map<String, String>>>() {}.getType();
        List<Map<String, String>> ordini = gson.fromJson(requestBody.toString(), tipoLista);
        if(ordini!=null) {
        for (Map<String, String> ordine : ordini) {
			System.out.println(ordine.get("nome_piatto")+" "+ ordine.get("id_piatto"));
		}
   
        response.setStatus(HttpServletResponse.SC_OK);
	}}
	
	
	       
	    
	


}
