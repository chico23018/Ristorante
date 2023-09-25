<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link href="css/index.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/menu.css" rel="stylesheet">
<script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
<title>Benvenuto al pomo d'oro!</title>

<link href="https://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
</head>

<body>
	<header>
		<span onclick="openMenu()" class="menu">&#9776;</span>
		<div id="myNav" class="overlay">
			<a href="javascript:void(0)" class="Xbtn" onclick="closeMenu()">&times;</a>
			<div class="ContenutoMenu">
				<a href="#">Home</a> <a href="#">Segreteria</a> <a href="logout.jsp">
					logout</a>
			</div>
			<div id="blocco" class="blocco"></div>
		</div>
	</header>

	<script src="js/menu.js"></script>
	<script src="js/obbligo_accesso.js"></script>
</body>

</html>