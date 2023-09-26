// Inizializza un array vuoto per memorizzare gli ordini aggiunti
const ordiniAggiunti = [];

// Funzione per aggiungere un piatto all'array
function aggiungiPiatto(nome, prezzo) {
    const nuovoPiatto = { nome, prezzo };
    ordiniAggiunti.push(nuovoPiatto);
    aggiornaTabellaOrdini();
}

// Funzione per aggiornare la tabella degli ordini
function aggiornaTabellaOrdini() {
    const tabella = document.getElementById('ordiniAggiunti');
    tabella.innerHTML = ''; // Pulisce la tabella

    // Aggiunge gli ordini alla tabella
    ordiniAggiunti.forEach((ordine, index) => {
        const row = tabella.insertRow(index);
        const cellNome = row.insertCell(0);
        const cellPrezzo = row.insertCell(1);

        cellNome.innerHTML = ordine.nome;
        cellPrezzo.innerHTML = '&euro;' + ordine.prezzo.toFixed(2);
    });
}
// ... Il codice JavaScript precedente ...

// Funzione per inviare gli ordini alla servlet
function inviaOrdini() {
    // Verifica se ci sono ordini da inviare
    if (ordiniAggiunti.length === 0) {
        alert('Nessun ordine da inviare.');
        return;
    }

    // Crea un oggetto JSON con gli ordini
    const datiDaInviare = JSON.stringify(ordiniAggiunti);

    // Effettua la richiesta HTTP POST
    fetch('/tua_servlet_url', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: datiDaInviare
    })
    .then(response => {
        if (response.ok) {
            alert('Ordini inviati con successo.');
            // Puoi fare qualcosa in caso di successo, ad esempio cancellare gli ordini locali
            ordiniAggiunti.length = 0;
            aggiornaTabellaOrdini(); // Aggiorna la tabella degli ordini locali
        } else {
            alert('Errore durante l\'invio degli ordini.');
        }
    })
    .catch(error => {
        console.error('Errore durante la richiesta:', error);
        alert('Errore durante l\'invio degli ordini.');
    });
}
function aggiornaTabellaOrdini() {
    const tabella = document.getElementById('ordiniAggiunti');
    tabella.innerHTML = ''; // Pulisce la tabella

    // Aggiunge gli ordini alla tabella
    ordiniAggiunti.forEach((ordine, index) => {
        const row = tabella.insertRow(index);
        const cellNome = row.insertCell(0);
        const cellPrezzo = row.insertCell(1);
        const cellRimuovi = row.insertCell(2);

        cellNome.innerHTML = ordine.nome;
        cellPrezzo.innerHTML = '&euro;' + ordine.prezzo.toFixed(2);
        const rimuoviButton = document.createElement('button');
        rimuoviButton.textContent = 'Rimuovi';
        rimuoviButton.addEventListener('click', () => rimuoviPiatto(index));
        cellRimuovi.appendChild(rimuoviButton);
    });
}
// Funzione per rimuovere un piatto dall'array
function rimuoviPiatto(index) {
    if (index >= 0 && index < ordiniAggiunti.length) {
        ordiniAggiunti.splice(index, 1);
        aggiornaTabellaOrdini();
    }
}
