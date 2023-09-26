// Inizializza un array vuoto per memorizzare gli ordini aggiunti
const ordiniAggiunti = [];

// Funzione per aggiungere un piatto all'array
function aggiungiPiatto(id_piatto, nome_piatto, costo, descrizione) {
    const nuovoPiatto = { id_piatto, nome_piatto, costo, descrizione };
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
       
        const cellIdPiatto = row.insertCell(0);
        const cellNome = row.insertCell(1);
        const cellCosto = row.insertCell(2);
        const cellDescrizione = row.insertCell(3);
        

        cellIdPiatto.innerHTML = ordine.id_piatto;
        cellNome.innerHTML = ordine.nome_piatto;
        cellCosto.innerHTML = '&euro;' + ordine.costo.toFixed(2);
        cellDescrizione.innerHTML = ordine.descrizione;
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
    fetch('Ordina', {
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
        const cellIdPiatto = row.insertCell(0);
        const cellNome = row.insertCell(1);
        const cellCosto = row.insertCell(2);
        const cellDescrizione = row.insertCell(3);
        const cellRimuovi = row.insertCell(4);

        cellIdPiatto.innerHTML = ordine.id_piatto;
        cellNome.innerHTML = ordine.nome_piatto;
        cellCosto.innerHTML = '&euro;' + ordine.costo.toFixed(2);
        cellDescrizione.innerHTML = ordine.descrizione;

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
