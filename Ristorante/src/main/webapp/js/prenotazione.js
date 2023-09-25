$(document).ready(function () {

	$("tr #Cant").click(function (e) {
	var nome = document.getElementById("nome").value;
	var cognome = document.getElementById("cognome").value;
	var idtavolo = document.getElementById("table").value;
	var url = "Prenota";
	console.log(nome, cognome,idtavolo);
	$.ajax({
		type: 'POST',
		url: url,
		data: "nome=" + nome + "&cognome=" + cognome+ "&id_tavolo=" +idtavolo,
		success: function(data, textStatus, jqXHR) {
			window.location.href = "http://localhost:8080/Ristorante/";
			//parent.location.href ="http://localhost:8080/Ristorante/";
			
		}
	});
});   

});
