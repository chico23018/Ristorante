<%@page import="model.Tavolo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Area Cameriere</title>
</head>
<style>
        /* Estilo para las mesas */
        .mesa {
            width: 200px;
            height: 200px;
            background-color: #ccc;
            margin: 10px;
            display: inline-block;
            cursor: pointer;
        }
     </style>
<body>
<%String nome = (String)request.getAttribute("nome");
  String cognome = (String)request.getAttribute("cognome");
  List<Tavolo> list = (List<Tavolo>)request.getAttribute("list");%>
<h1>Benvenuto <%=nome+" "+cognome%></h1></body>
</body>

<%for(Tavolo ta :list){ %>
 <div class="mesa" onclick="mostrarInformacionMesa(1)">Mesa 1
    
    </div>
<%} %>

<!-- 
Aggiungere un ordine 
Vedere lo stato di un tavolo
Vedere lo stato di un pagamento
 -->

</html>