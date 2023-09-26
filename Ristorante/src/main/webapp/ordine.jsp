<%@page import="model.Piatto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Ordine</title>
<link href="css/style.css" rel="stylesheet">
<link href="css/menu.css" rel="stylesheet">
<link href="css/ordine.css" rel="stylesheet">
</head>

<body>
	<%
	List<Piatto> lista_piatti = (List<Piatto>) session.getAttribute("lista_piatti");
	%>
	<div class="freccia">
		<a href="javascript: window.history.go(-1)"> <img
			src="sources/frecciasinistra.png" alt="Icona" width="30" height="30"
			class="logo">
		</a>
	</div>


		<table class="table" id="ordine">
			<tr>
				<th>Numero</th>
				<th>Nome</th>
				<th>Prezzo</th>
				<th>Descrizione</th>
				<th>aggiungi</th>
			</tr>
			<%
			for (Piatto p : lista_piatti) {
			%>
			<tr>
				<td><%=p.getId_piatto()%></td>
				<td><%=p.getNome_piatto()%></td>
				<td>&euro;<%=p.getCosto()%></td>
				<td><%=p.getDescrizione()%></td>
				<td><input type="submit" value="aggiungi"/> </td>
			</tr>
			<%
			}
			%>
		</table>
	

</body>

</html>