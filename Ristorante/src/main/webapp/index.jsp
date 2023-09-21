<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="css/index.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		<script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
		<title>Benvenuto!</title>
	</head>
	
	<body style="background:#FFA500">
		
		
		
		<div class="form">
			<form action="login" method="post">
				<div><h2>Login</h2><img src="sources/logo.png" class="logo"></div>
				<h3>Username</h3>
				<input type="text" name="username" id="username" class="username">
				<h3>Password</h3>
				<div class="div_pass">
					<div class="pass_in">
						<input type="password" name="password" id="password">
					</div>
					<div class="icona">
						<box-icon class="mostra_pss" id="hide" type='solid' name='hide'></box-icon>
					</div>
				</div>
				<span class="errore" id="errore">
					<%String messaggio= (String)request.getAttribute("messaggio");%>
					<% 
					if(messaggio!=null){%>   
						<p ><%out.print("Username o Password non sono corretti");%></p>
					<%} %>
				</span>
				<button type="submit" value="Accedi" id="submit">Accedi</button>
			</form>
		</div>
		<footer>
        	<p>&copy; Università  degli Studi di Napoli Federico II</p>
  		</footer>
	</body>
	<script src="./js/obbligo_accesso.js"></script>
</html>