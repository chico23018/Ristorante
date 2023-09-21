<%@page import="model.Tavolo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Area Cameriere</title>
<link href="css/tavolo.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<%
String nome = (String) request.getAttribute("nome");
String cognome = (String) request.getAttribute("cognome");
List<Tavolo> list = (List<Tavolo>) request.getAttribute("list");
%>
	<h1>
		Benvenuto
		<%=nome + " " + cognome%></h1>

	<%for (Tavolo ta : list) {%>
	<div class="tavolo">
		<a href="login?id=<%=ta.getId_tavolo()%>"> 
			Tavolo <%=ta.getId_tavolo()%>
		</a>
	</div>
	<%}%>

</body>
<!-- 
Aggiungere un ordine 
Vedere lo stato di un tavolo
Vedere lo stato di un pagamento

 -->

</html>