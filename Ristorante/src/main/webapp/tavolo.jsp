<%@page import="java.util.List"%>
<%@page import="model.Cliente"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Tavolo</title>
<link href="css/style.css" rel="stylesheet">
<link href="css/menu.css" rel="stylesheet">
<link href="css/tavolo.css" rel="stylesheet">
</head>

<body>
	<%
	Cliente cliente = (Cliente) request.getAttribute("cliente");
	int n_tavolo = (int) request.getAttribute("n_tavolo");
	List<Map<String, String>> resultList = (List<Map<String, String>>) request.getAttribute("resultList");
	double costo_totale = (double) request.getAttribute("totale");
	String id_pagamento = (String) request.getAttribute("id_pagamento");
	String cognome = (String) request.getAttribute("cognome");
	String id_cameriere = (String) request.getAttribute("idCameriere");
	%>

	<!--  navbar  -->
	<nav class="navbar">
		<a href="javascript: window.history.go(-1)"> <img
			src="sources/frecciasinistra.png" alt="Icona" width="30" height="30"
			class="logo">
		</a>
		<div class="menu">
			<span onclick="openMenu()">&#9776;</span>
			<div id="myNav" class="overlay">
				<a href="javascript:void(0)" class="Xbtn" onclick="closeMenu()">&times;</a>
				<div class="ContenutoMenu">
					<%if(!cognome.equals("Prendi in carico")){%>
				    <a href="Ordina?id_tavolo=<%=n_tavolo%>">Aggiungi un ordine</a> 
				    <%}%>
					<a href="logout.jsp">Logout</a>
				</div>
				<div id="blocco" class="blocco"></div>
			</div>
		</div>
	</nav>

	<!--  form  -->

	<form action="Pagamento" method="post">
		<div class="divisore">
			<table class="table">
				<tr>
					<th>Tavolo no.</th>
					<th>Prenotazione</th>
					<th>Gestito</th>
					<th>Ordine</th>
					<th>Totale</th>
				</tr>
				<tr>
					<td><%=n_tavolo%></td>
					<%if(cliente.getCognome_cliente() == null)
						cliente.setCognome_cliente("Non riservato");
					%>
					<td><%=cliente.getCognome_cliente()%></td>
					
					<%if(cognome.equals("Prendi in carico")&& 
						!cliente.getCognome_cliente().equals("Non riservato")){%>
					<td><a href="assegna?id_cameriere=<%=id_cameriere%>&id_tavolo=<%=n_tavolo%>" 
					id="prendi-in-carico">Prendi in carico</a></td>
					<%}else if(cognome.equals("Prendi in carico")){%>
					<td>Non gestito</td>
					<%}else{%>
					<td><%=cognome%></td>
					<%}%>
					<%if(!resultList.isEmpty()){%>
					<td><a href="#" id="visualizza-ordine">Visualizza ordine</a></td>
					<%}else{%>
					<td>Nessun ordine</td>
					<%}%>
					<td><%=costo_totale%></td>
				</tr>
			</table>
		</div>
		<br>
		<input type="hidden" name="id" value="<%=id_pagamento%>"> 
		<%if(!resultList.isEmpty()){%>
		<button type="submit" class="button">Paga ora</button>
		<%}%>
	</form>
	
	<!--  tabella ordini  -->
		
	<table class="table" id="tabella-ordine" style="display: none;">
		<tr >
			<td colspan="5" style="text-align: right;">
				
				<a href="#" id="chiudi-ordine">&times;</a>
				
			</td>
		</tr>
		<tr>
			<th>Nome piatto</th>
			<th>Descrizione</th>
			<th>Stato ordine</th>
			<th>Quantit&agrave;</th>
			<th>Prezzo</th>
		</tr>
		<%
		for (Map<String, String> row : resultList){
		%>
		<tr>
			<td><%=row.get("nome")%></td>
			<td><%=row.get("descrizione")%></td>
			<td><%=row.get("stato")%></td>
			<td><%=row.get("quantita")%></td>
			<td>&euro;<%=row.get("costo")%></td>
		</tr>
		<%
		}
		%>
		
	</table>


	<script src="js/menu.js"></script>
	<script src="https://cdn.lordicon.com/bhenfmcm.js"></script>
	<script src="js/obbligo_accesso.js"></script>
	<script src="js/visualizza_ordine.js"></script>

</body>

</html>