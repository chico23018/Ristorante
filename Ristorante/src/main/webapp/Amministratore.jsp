<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Area Amministratore</title>
</head>
<body>
<%String nome = (String)request.getAttribute("nome");
  String cognome = (String)request.getAttribute("cognome");%>
<h1>Benvenuto <%=nome+" "+cognome%></h1></body>

<!-- 
Aggiungere un ordine 
Visualizzare lo stato di tutti i tavoli
Vedere lo stato di un pagamento
Modificare lo stato di un pagamento o aggiungerne uno
Aggiungere un piatto
Modificare il prezzo di un piatto
 -->
 
</html>