
        //////////////////SCRIPT PER LA MAP///////////////////
        var marker; // Dichiarazione globale della variabile marker

        // Creazione della mappa
        var map = L.map('map').setView([43.178865128124244, 12.310475342504484],
            12); // Sostituisci con le tue coordinate e il livello di zoom desiderato

        // Aggiungi una mappa di base
        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        }).addTo(map);

        function trovaCoordinate() {
            let latitude = "";
            let longitude = "";

            // const address = document.getElementById('indirizzo').value;
            let evento = JSON.parse(localStorage.getItem("evento"));

            // console.log(evento);
            fetch(`https://nominatim.openstreetmap.org/search?format=json&q=${evento.luogo_evento}`)
                .then(response => response.json())
                .then(data => {
                    if (data.length > 0) {
                        const result = data[0];
                        const latitude = result.lat;
                        const longitude = result.lon;

                        // Aggiorna la mappa con le coordinate trovate
                        map.setView([latitude, longitude]);
                        if (marker) {
                            map.removeLayer(marker);
                        }

                        marker = L.marker([latitude, longitude]).addTo(map)
                            .bindPopup(`${evento.luogo_evento}`).openPopup();
                    } else {
                        alert('Indirizzo non trovato.');
                    }
                });
        }
        document.addEventListener("DOMContentLoaded", trovaCoordinate);