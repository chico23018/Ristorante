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
					<a href="#">Aggiungi Tavolo</a> <a href="logout.jsp">Logout</a>
				</div>
				<div id="blocco" class="blocco"></div>
			</div>
		</div>
	</nav>

	<form>
		<div class="divisore">
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
					<td>
						<a href="#" id="visualizza-ordine">Visualizza ordine</a></td>
					<td>&euro; 35.90</td>
				</tr>
			</table>
		</div>
		<br>
		<a href="" class="button">Paga ora</a>
	</form>

	<table class="table" id="tabella-ordine" style="display: none;">
		<tr>
			<td colspan="4" style="text-align: right;">
				<a href="#" id="chiudi-ordine">&times;</a>
			</td>
		</tr>
		<tr>
			<th>Nome piatto</th>
			<th>Descrizione</th>
			<th>Quantita'</th>
			<th>Prezzo</th>
		</tr>
		<tr>
			<td>Margherita</td>
			<td>Pomodoro mozzarella basilico e origano</td>
			<td>3</td>
			<td>&euro; 7.50</td>
		</tr>
		<tr>
			<td>Patatine</td>
			<td>Deliziose patatine fritte</td>
			<td>5</td>
			<td>&euro; 1.50</td>
		</tr>
	</table>

	<script src="js/menu.js"></script>
	<script src="https://cdn.lordicon.com/bhenfmcm.js"></script>
	<script src="js/obbligo_accesso.js"></script>
	<script src="js/visualizza_ordine.js"></script>

</body>

</html>