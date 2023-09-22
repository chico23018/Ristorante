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
<link href="css/menu.css" rel="stylesheet">
</head>

<body>
	<%
	String nome = (String) request.getAttribute("nome");
	String cognome = (String) request.getAttribute("cognome");
	List<Tavolo> list = (List<Tavolo>) request.getAttribute("list");
	%>
	<header>
		<span onclick="openMenu()" class="menu">&#9776;</span>
		<div id="myNav" class="overlay">
			<a href="javascript:void(0)" class="Xbtn" onclick="closeMenu()">&times;</a>
			<div class="ContenutoMenu">
				</a><a href="#">Aggiungi Tavolo</a> 
	   		        <a href="logout.jsp">logout</a>
			</div>
			<div id="blocco" class="blocco"></div>
		</div>
	</header>
	<h1>
		Benvenuto
		<%=nome + " " + cognome%></h1>

	<%
	for (Tavolo ta : list) {
	%>
	<div class="tavolo">
		<a href="login?id=<%=ta.getId_tavolo()%>"> Tavolo <%=ta.getId_tavolo()%>
		</a>
	</div>
	<%
	}
	%>

	<script src="js/menu.js"></script>
</body>
<!-- 
Aggiungere un ordine 
Vedere lo stato di un tavolo
Vedere lo stato di un pagamento

 -->

</html>