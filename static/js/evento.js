
        /////////////SCRIPT PER LA PAGINA EVENTO////////////
        let evento = JSON.parse(localStorage.getItem("evento"));
        let nPosti = document.querySelector("#nPosti");
        let postiPrenotati = 0;

        function recuperaPosti() {
            fetch(`http://localhost:9007/p/prenotazioni/evento/${evento.id}`)
                .then(res => res.json())
                .then(data => {
                    // console.log(data);
                    if (data.length <= 0) {
                        trovaEvento();
                    } else {
                        data.forEach(prenotazione => {
                            postiPrenotati += prenotazione.posti;
                            trovaEvento();
                        });
                    }
                })
        }

        function trovaEvento() {

            let imgTag = document.querySelector("#imgEvento");
            let nomeEvento = document.querySelector("#nomeEvento");
            let citta = document.querySelector("#citta");
            let data = document.querySelector("#data");
            let disponibilita = document.querySelector("#disponibilita");
            let prezzo = document.querySelector("#prezzo");


            imgTag.setAttribute("src", "./img/" + evento.locandina);

            let postiRimanenti = evento.disponibilita - postiPrenotati;
            let nome = `<h3 class="fw-bold">${evento.descrizione}</h3>`
            let caratteristiche = `${evento.caratteristiche}`
            data.innerHTML = `${evento.data_evento}`;
            prezzo.innerHTML = `€ ${(evento.prezzo).toFixed(2)}`;
            if (postiRimanenti <= 0) {
                disponibilita.innerHTML = "Posti esauriti!";
                let btnCompra = document.querySelector("#compra");
                btnCompra.setAttribute("disabled", "");
                btnCompra.setAttribute("class", "btn btn-outline-accent rounded-2 text-dark");
                btnCompra.textContent = "POSTI ESAURITI";
            } else {
                disponibilita.innerHTML = `Ancora ${postiRimanenti} posti rimasti!`;
            }
            citta.innerHTML = `${evento.luogo_evento}`;
            nomeEvento.innerHTML = nome;
        }
        
        //////////////////AGGIUNGI AL CARRELLO: SOLO DA PAGINA EVENTO///////////

        function Prenotazione(utenti_id, evento_id, posti) {
            this.utenti_id = utenti_id;
            this.evento_id = evento_id;
            this.posti = posti;
        }

        function aggiungiCarrello() {

            let arrPrenotazioni = JSON.parse(localStorage.getItem("prenotazioni"));
            let utenteOn = JSON.parse(localStorage.getItem("utente"));
            let prenotazione = new Prenotazione(utenteOn.id, evento.id, Number(nPosti.value));

            if (arrPrenotazioni != null) {
                arrPrenotazioni.push(prenotazione);
                localStorage.setItem("prenotazioni", JSON.stringify(arrPrenotazioni));
            } else {
                let newArrPrenotazioni = [];
                newArrPrenotazioni.push(prenotazione);
                localStorage.setItem("prenotazioni", JSON.stringify(newArrPrenotazioni));
            }



            let arrCarrello = [];
            let carrelloUtente = JSON.parse(localStorage.getItem("Carrello"));
            // console.log(carrelloUtente);

            let btnCompra = document.querySelector("#compra");



            if (carrelloUtente == null) {
                // console.log("aggiungiCarrello1");
                arrCarrello.push(evento);
                localStorage.setItem("Carrello", JSON.stringify(arrCarrello));

            } else {

                let oggettoNelCarrello = carrelloUtente.find(function (res) {
                    return res.id == this.id;
                }, evento);
                // console.log(oggettoNelCarrello);
                if (oggettoNelCarrello != undefined) {
                    btnCompra.setAttribute("disabled", "");
                    btnCompra.textContent = "Già nel carrello!";
                }


                let altriArticoli = carrelloUtente;
                arrCarrello = [];
                // arrCarrello.push(altriArticoli);
                altriArticoli.forEach(element => {
                    // console.log("aggiungiCarrello");
                    arrCarrello.push(element);
                });
                arrCarrello.push(evento);
                localStorage.setItem("Carrello", JSON.stringify(arrCarrello));
            }

            verificaArticoli();
            verificaCarrello();
        }//////////////////////////////////////FINE FUNZIONE