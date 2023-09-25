const formulario_ajax = document.querySelectorAll(".Prenota");

function enviar_formulario_ajax(e){
e.preventDefault();
window.location.href='./index.jsp'
}

formulario_ajax.forEach(formulario =>{
	formulario.addEventListener("submit",enviar_formulario_ajax);
});

