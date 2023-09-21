<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Area Cameriere</title>
</head>

<body>
<%String nome = (String)request.getAttribute("nome");
  String cognome = (String)request.getAttribute("cognome");%>
<h1>Benvenuto <%=nome+" "+cognome%></h1></body>
</body>

<!-- 
Aggiungere un ordine 
Vedere lo stato di un tavolo
Vedere lo stato di un pagamento
 -->

</html>