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
</head>

<body>
	<%Cliente cliente = (Cliente) request.getAttribute("cliente");%>
	
	
	
	<header>
		<span onclick="openMenu()" class="menu">&#9776;</span>
		<div id="myNav" class="overlay">
			<a href="javascript:void(0)" class="Xbtn" onclick="closeMenu()">&times;</a>
			<div class="ContenutoMenu">
				<a href="javascript: window.history.go(-2)">
				<!-- 
				<lord-icon
				    src="sources/frecciasinitra.json"
				    trigger="hover"
				    colors="primary:#121331"
				    style="width:50px;height:50px;transform: scaleX(-1);margin-top:10%;"
				    type="regular">
				</lord-icon>
				 -->
				<a href="#">
				    <img src="sources/frecciasinistra.png" alt="Icona" width="50" height="50">
				</a>
				

	   		</a><a href="#">Aggiungi Tavolo</a> <a href="logout.jsp">
					logout</a>
			</div>
			<div id="blocco" class="blocco"></div>
		</div>
	</header>
	
	<form>
	
	
	<table border="1">
    <tr>
        <th>Nome</th>
        <th>Cognome</th>
        <th>Totale da pagare</th>
        <th><button type="submit" >Pagare</button></th>
    </tr>
    
    
    <tr>
        <td>John</td>
        <td>Doe</td>
        <td>30</td>

    </tr>
    
    <tr>
        <td>John</td>
        <td>Doe</td>
    </tr>
</table>
	
	
</form>
<table border="1">
    <tr>
        <th>Piatto</th>
        <th>Descrizione</th>
        <th>Quantità</th>
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
	<script src="js/obbligo_accesso.js"></script>
</body>

</html>