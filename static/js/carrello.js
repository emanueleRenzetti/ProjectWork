
        ///////////////SCRIPT PER IL CARRELLO////////////////
        function verificaCarrello() {
            let carrelloUtente = localStorage.getItem("Carrello");
            // console.log(carrelloUtente);
            let btnCompra = document.querySelector("#compra");

            if (carrelloUtente != null) {
                let oggettoNelCarrello = JSON.parse(carrelloUtente).find(function (res) {
                    return res.id == this.id;
                }, evento);
                // console.log(oggettoNelCarrello);
                if (oggettoNelCarrello != undefined) {
                    btnCompra.setAttribute("disabled", "");
                    btnCompra.textContent = "Già nel carrello!";
                } else {
                    btnCompra.removeAttribute("disabled");
                    btnCompra.textContent = "Aggiungi al carrello";
                }
            } else {
                btnCompra.removeAttribute("disabled");
                btnCompra.textContent = "Aggiungi al carrello";
            }
        }

        document.addEventListener("DOMContentLoaded", verificaCarrello);



        function verificaArticoli() {
            // bodyCart.innerHTML="";
            let carrello = JSON.parse(localStorage.getItem("Carrello"));
            let nArticoli = document.querySelector("#nArticoli");
            let bodyCart = document.querySelector("#bodyCart");
            let btnCompra = document.querySelector("#btnCompraTutto");

            if (carrello != null) {

                if (carrello.length <= 0) {
                    nArticoli.textContent = "";
                    btnCompra.setAttribute("disabled", "");
                    bodyCart.textContent = "Il tuo carrello è vuoto";
                } else {
                    nArticoli.textContent = carrello.length;
                    bodyCart.innerHTML = "";
                    btnCompra.removeAttribute("disabled");


                    carrello.forEach(element => {

                        let quantita = Number(nPosti.value);
                        let tot = (element.prezzo * Number(nPosti.value)).toFixed(2);

                        bodyCart.innerHTML += `<div class="list-group list-group-flush border-bottom">
                                                    <div class="row w-100 align-items-center p-2">
                                                        <img class="img-fluid" src="./img/${element.locandina}"></img>
                                                            <div class="d-flex flex-column justify-content-center col-6">
                                                                <div class="fw-semibold">Evento</div>
                                                                <p id="" class="mb-0">${element.descrizione}</p>
                                                                <p id="" class="mb-0">Posti: ${quantita}</p>
                                                                <p><strong>PREZZO:</strong> ${tot} € </p>
                                                                <button class="btn btn-outline-danger" onclick="eliminaEvento(${element.id})">Elimina</button>
                                                            </div>
                                                    </div>
                                                </div>`;


                        let inputPosti = document.querySelector(`#inputPosti${element.id}`);

                    });

                }
            } else {
                nArticoli.textContent = "";
                btnCompra.setAttribute("disabled", "");
                bodyCart.textContent = "carrello vuoto";
            }
        }

        function prenotaEvento() {
            console.log("funzione vuota");
        }

        function eliminaEvento(id) {
            let carrello = JSON.parse(localStorage.getItem("Carrello"));
            let element = carrello.find(function (res) {
                return res.id == id;
            }, id);
            let nuovoCarrello = carrello.filter(item => item !== element);
            localStorage.setItem("Carrello", JSON.stringify(nuovoCarrello));
            let bodyCart = document.querySelector("#bodyCart");
            bodyCart.innerHTML = "";
            verificaArticoli();
            verificaCarrello();

            let prenotazioni = JSON.parse(localStorage.getItem("prenotazioni"));
            if (prenotazioni != null) {
                let miaPrenotazione = prenotazioni.find(function (pren) {
                    return pren.evento_id == id;
                }, id);
                if (miaPrenotazione != undefined) {
                    let nuovoArrPren = prenotazioni.filter(item => item !== miaPrenotazione);
                    localStorage.setItem("prenotazioni", JSON.stringify(nuovoArrPren));
                }
            }
        }

        let btnAdd = document.querySelector("#btnAdd");
        let btnRemove = document.querySelector("#btnRemove");

        function addPosti() {
            nPosti.stepUp();
        }

        function removePosti() {
            nPosti.stepDown();
        }

        let btnCompraTutto = document.querySelector("#btnCompraTutto");
        let carrelloModal = document.querySelector("#carrelloModal");

        function compraTutto() {
            while (carrelloModal.firstChild) {
                carrelloModal.removeChild(carrelloModal.firstChild);
            }
            let prenotazioni = JSON.parse(localStorage.getItem("prenotazioni"));
            let idInput = 0;
            let totDaPagare = 0;
            let eventiDB = JSON.parse(localStorage.getItem("eventiDB"));

            prenotazioni.forEach(pren => {
                // fetch("http://localhost:9007/e/eventi/" + pren.evento_id).then(data => data.json())
                //     .then(res => {
                let res = eventiDB.find(function (evento) {
                    return evento.id == this.evento_id;
                }, pren);

                let h5Tot = document.querySelector("#h5Tot");

                let card = document.createElement("div");
                card.setAttribute("class", "card");

                let img = document.createElement("img");
                img.setAttribute("class", "card-img-top");
                img.setAttribute("src", "./img/" + res.locandina);
                card.appendChild(img);

                let cardBody = document.createElement("div");
                cardBody.setAttribute("class", "card-body");
                card.appendChild(cardBody);

                let totale = res.prezzo * pren.posti;

                // Creazione di un elemento <h5> con l'attributo class
                var h5Element = document.createElement("h5");
                h5Element.setAttribute("class", "card-title");
                h5Element.textContent = res.caratteristiche;

                // Creazione di un elemento <p> con l'attributo class
                var pElement = document.createElement("p");
                pElement.setAttribute("class", "card-text");
                pElement.textContent = res.descrizione;

                // Creazione di un elemento <div> con l'attributo class
                var divElement = document.createElement("div");
                divElement.setAttribute("class", "input-group mb-3");

                // Creazione dei bottoni "-" e "+"
                var buttonMinus = document.createElement("button");
                buttonMinus.setAttribute("onclick",
                    `document.getElementById('quantita${idInput}').stepDown(1)`);
                buttonMinus.setAttribute("class",
                    "btn btn-outline-secondary border-0 rounded-start-4 rounded-end-0");
                buttonMinus.textContent = "-";

                var buttonPlus = document.createElement("button");
                buttonPlus.setAttribute("onclick",
                    `document.getElementById('quantita${idInput}').stepUp(1)`);
                buttonPlus.setAttribute("class",
                    "btn btn-outline-secondary border-0 rounded-start-0 rounded-end-4");
                buttonPlus.textContent = "+";

                // Creazione dell'input
                var inputElement = document.createElement("input");
                inputElement.setAttribute("value", pren.posti);
                inputElement.setAttribute("min", "1");
                inputElement.setAttribute("id", `quantita${idInput}`);
                inputElement.setAttribute("type", "number");
                inputElement.setAttribute("class", "form-control text-center");
                inputElement.setAttribute("placeholder", "1");
                inputElement.setAttribute("readonly", "true");

                // Creazione di un elemento <p> 
                var pTotal = document.createElement("p");
                // pTotal.textContent = totale;

                divElement.appendChild(buttonMinus);
                divElement.appendChild(inputElement);
                divElement.appendChild(buttonPlus);
                divElement.appendChild(pTotal);

                cardBody.appendChild(h5Element);
                cardBody.appendChild(pElement);
                cardBody.appendChild(divElement);

                function disabilitaBtnMeno() {
                    if (inputElement.value <= 1) {
                        buttonMinus.setAttribute("disabled", "");
                    } else {
                        buttonMinus.removeAttribute("disabled");
                    }

                }

                function setPrenotazione() {
                    let nuovoArrPren = prenotazioni.filter(item => item !== pren);
                    pren.posti = Number(inputElement.value);
                    nuovoArrPren.push(pren);
                    localStorage.setItem("prenotazioni", JSON.stringify(nuovoArrPren));
                    console.log(nuovoArrPren);
                }


                function attivaEvento() {
                    var inputEvent = new Event("input", {
                        bubbles: true
                    });
                    inputElement.dispatchEvent(inputEvent);
                }

                function stampaTot() {
                    totDaPagare += Number(res.prezzo);
                    h5Tot.textContent = "Totale: " + totDaPagare.toFixed(2) + " €";
                }

                function stampaTotMeno() {
                    totDaPagare -= Number(res.prezzo);
                    h5Tot.textContent = "Totale: " + totDaPagare.toFixed(2) + " €";
                }

                function stampaPrezzo() {
                    let inp = document.querySelector(`#quantita${idInput}`);
                    totale = res.prezzo * Number(inputElement.value);
                    pTotal.textContent = "Totale: " + totale.toFixed(2) + " €";
                }

                function totAlCaricamento() {
                    totDaPagare += totale;
                    h5Tot.textContent = "Totale: " + totDaPagare.toFixed(2) + " €";
                }

                function vaiAlPagamento() {
                    let totDefinitivo = h5Tot.textContent;
                    let h5Totale = document.querySelector("#h5Totale");
                    h5Totale.textContent = totDefinitivo;


                    //inserisci nella local un array di prenotazioni
                }

                let btnAlPagamento = document.querySelector("#btnAlPagamento");
                btnAlPagamento.addEventListener("click", vaiAlPagamento);

                stampaPrezzo();
                totAlCaricamento();


                carrelloModal.appendChild(card);

                buttonPlus.addEventListener("click", function () {
                    attivaEvento();
                    disabilitaBtnMeno();
                    stampaPrezzo();
                    stampaTot()
                })

                buttonMinus.addEventListener("click", function () {
                    attivaEvento();
                    disabilitaBtnMeno();
                    stampaPrezzo();
                    stampaTotMeno();
                })

                inputElement.addEventListener("input", setPrenotazione);
                idInput++;

            }); //foreach
        }

        let btnPagaOra = document.querySelector("#pagaOra");

        function pagaOra() {
            alert("PAGAMENTO RIUSCITO")
            let prenotazioni = JSON.parse(localStorage.getItem("prenotazioni"));
            prenotazioni.forEach(element => {
                fetch("http://localhost:9007/p/prenotazioni", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(element)
                }).then(data => data.json())
                .then(res =>{
                    localStorage.removeItem("Carrello");
                    localStorage.removeItem("prenotazioni");
                    location.href="home.html";
                })
            });
        }

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

        btnPagaOra.addEventListener("click", pagaOra);

        btnCompraTutto.addEventListener("click", compraTutto);

        btnRemove.addEventListener("click", removePosti);
        btnAdd.addEventListener("click", addPosti);
        document.addEventListener("DOMContentLoaded", verificaArticoli);
        document.addEventListener("DOMContentLoaded", recuperaPosti);