document.addEventListener("DOMContentLoaded", function () {
  const visualizzaOrdineLink = document.getElementById("visualizza-ordine");
  const tabellaOrdine = document.getElementById("tabella-ordine");

  visualizzaOrdineLink.addEventListener("click", function (event) {
    event.preventDefault(); // Impedisce al link di navigare a una nuova pagina
    tabellaOrdine.style.display = "table"; // Mostra la tabella dell'ordine
  });
});

document.addEventListener("DOMContentLoaded", function () {
  const visualizzaOrdineLink = document.getElementById("visualizza-ordine");
  const chiudiOrdineLink = document.getElementById("chiudi-ordine");
  const tabellaOrdine = document.getElementById("tabella-ordine");

  visualizzaOrdineLink.addEventListener("click", function (event) {
    event.preventDefault(); // Impedisce al link di navigare a una nuova pagina
    tabellaOrdine.style.display = "table"; // Mostra la tabella dell'ordine
  });

  chiudiOrdineLink.addEventListener("click", function (event) {
    event.preventDefault(); // Impedisce al link di navigare a una nuova pagina
    tabellaOrdine.style.display = "none"; // Nasconde la tabella dell'ordine
  });
});