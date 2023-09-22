<%@page import="model.Cliente"%>
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
	%>

	<header>
		<a href="javascript: window.history.go(-1)" class="back-link"> <img
			src="sources/frecciasinistra.png" alt="Icona" width="50" height="50">
		</a> 
		<span onclick="openMenu()" class="menu">&#9776;</span>
		<div id="myNav" class="overlay">
			<a href="javascript:void(0)" class="Xbtn" onclick="closeMenu()">&times;</a>
			<div class="ContenutoMenu">
				<a href="#">Aggiungi Tavolo</a> <a href="logout.jsp"> Logout</a>
			</div>
			<div id="blocco" class="blocco"></div>
		</div>
	</header>

	<form>
		<table class="table">
			<tr>
				<th>Tavolo no.</th>
				<th>Prenotazione</th>
				<!-- es. Prenotazione = Martinez -->
				<th>Ordine</th>
				<!-- Deve essere la lista dei piatti nell'ordine -->
				<th>Totale</th>
			</tr>
			<tr>
				<td><%=n_tavolo%></td>
				<td><%=cliente.getCognome_cliente()%></td>
				<td>30</td>
				<td>30</td>
			</tr>
			<tr>
				<td>John</td>
				<td>Doe</td>
				<td>30</td>
				<td>30</td>
			</tr>
			<tr>
				<td>John</td>
				<td>Doe</td>
				<td>30</td>
				<td>30</td>
			</tr>
		</table>
		<br />
		<th><a href="" class="button">Paga ora</a></th>
	</form>

	<table border="1">
		<tr>
			<th>Piatto</th>
			<th>Descrizione</th>
			<th>Quantita'</th>
			<th>Prezzo</th>
		</tr>
		<tr>
			<td>John</td>
			<td>Doe</td>
			<td>30</td>
		</tr>
		<tr>
			<td>Jane</td>
			<td>Smith</td>
			<td>25</td>
		</tr>
		<tr>
			<td>Bob</td>
			<td>Johnson</td>
			<td>35</td>
		</tr>
	</table>


	<script src="js/menu.js"></script>
	<script src="https://cdn.lordicon.com/bhenfmcm.js"></script>
	<script src="js/obbligo_accesso.js"></script>
</body>

</html>