<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<!DOCTYPE html>
		<html>

		<head>
			<meta charset="ISO-8859-1">
			<link href="css/index.css" rel="stylesheet" type="text/css">
			<link href="css/style.css" rel="stylesheet" type="text/css">
			<link rel="stylesheet" href="css/menu.css">
			
			<script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
			<script src="js/menu.js"></script>
			<title>Benvenuto al pomo d'oro!</title>

			<link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
			<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
				integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
				crossorigin="anonymous">
        <style type="text/css">header{
	text-align:center;
	
	padding:10px;
	margin:-10px; 
	width:101%; 
	height:100%; 
}</style> 
		</head>
	

		<body>
			<header>
               <span onclick="openMenu()" class="menu">&#9776;</span>
                  <div id="myNav" class="overlay">
                      <a href="javascript:void(0)" class="Xbtn" onclick="closeMenu()">&times;</a>
                      <div class="ContenutoMenu">
                		 <a href="#">Home</a>
                		 <a href="#">Segreteria</a>
                		 <a href="logout.jsp"> logout</a>
                      </div>
                      <div id="blocco" class="blocco">
        	          </div>
                   </div>
		  </header>
			

			<footer class="footer mt-3" id="Contatti">
				<div class="grid2">
					<div class="col reveal">
						<h4 class="flex-text2 tw">Contatti</h4>
						<p class="normal-text tw">
							<img src="sources/cornetta_telefonica.png" alt="icona" style="vertical-align: middle;">
							<a href="tel:+393487678837"style="font-size: 15px">+39 </a>
						</p>
						<p class="normal-text tw">
							<img src="sources/mail.png" alt="icona" style="vertical-align: middle;">
							<a href="mailto:nome.cognome@mail.it" style="font-size: 14px">nome.cognome@mail.it</a>
						</p>
					</div>

					<div class="col reveal">
						<h4 class="flex-text2 tw">Social</h4>
						<p class="normal-text tw">
							<img src="sources/insta.png" alt="icona" style="vertical-align: middle;">
							<a href="" style="font-size: 14px">@nome_instagram</a>
						</p>
						<p class="normal-text tw">
							<img src="sources/facebook.png" alt="icona"
								style="vertical-align: middle; margin-right: 20px;">
							<a href="" style="font-size: 14px">nome_facebook</a>
						</p>
					</div>

					<div class="col reveal">
						<h4 class="flex-text2 tw">Orari servizio</h4>
						<p class="pw" style="color: white;">Aperti tutti i giorni dal Martedi alla Domenica</p>
						<p class="pw" style="color: white;">Pranzo:  12:00-15:00</p>
						<p class="pw" style="color: white;">Cena:  20:00-00:00</p>
					</div>

					<div class="col reveal">
						<h4 class="flex-text2 tw">Partita IVA</h4>
						<p class="pw" style="color: white;">IVA</p>
					</div>

				</div>
			</footer>


		</body>
		<script src="js/obbligo_accesso.js"></script>
		

		</html>