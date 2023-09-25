<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="model.Tavolo"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Prenotazione</title>
<link href="css/style.css" rel="stylesheet">
<link href="css/prenotazione.css" rel="stylesheet">
</head>

<body>
	<%
	List<Tavolo> tavoli_liberi = (List<Tavolo>) request.getAttribute("tavoli_liberi");
	%>
	
	<%
	if(!tavoli_liberi.isEmpty())
	{
	%>
	<div class="form">
		<form action="login" method="post">
			<h1>Prenotazione</h1>
			<h3>Nome</h3>
			<input type="text" name="nome" id="nome" class="nome">
			<h3>Cognome</h3>
			<input type="text" name="cognome" id="cognome" class="nome">
			<h3 for="table">Scegli un tavolo per </h3>
			<select id="table" name="table">
			<%
			for (Tavolo t : tavoli_liberi){
			%>
			<option value="<%=t.getId_tavolo()%>"><%=t.getNum_posti()%> persone</option>
			<%
			}
			%>
			</select>
			
			<button type="submit" value="prenota" id="submit" class="button">Prenota</button>
		</form>
	</div>
	<%
	}else{
	%>
	<p class="message">Siamo spiacenti, al momento non ci sono tavoli liberi</p>
	<%
	}
	%>
	
</body>

</html>