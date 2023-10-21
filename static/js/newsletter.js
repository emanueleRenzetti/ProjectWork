 // SCRIPT PER LA NEWSLETTER
        //input della newsletter
        let emailFake = document.querySelector("#emailFake");

        //COSTRUTTORE di email con recupero di data al momento della creazione
        function Email(email) {
            data = new Date();
            this.iscrizione = data;
            this.email = email;
        }

        //al click su btnIscriviti controllo che il campo input non sia vuoto e registro la nuova email nel DB
        function iscriviti() {
            if (emailFake.value.trim() == "") {
                emailFake.value = "";
                emailFake.setAttribute("placeholder", "Inserisci una mail valida");
            } else {
                let miaEmail = new Email(emailFake.value);
                fetch("http://localhost:9007/em/email", {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/json"
                        },
                        body: JSON.stringify(miaEmail)
                    }).then(data => data.json())
                    .then(res => {
                        emailFake.value = "";
                        emailFake.setAttribute("placeholder", "Iscritto correttamente!");
                    })
            }
        }

        let btnIscriviti = document.querySelector("#btnIscriviti");
        btnIscriviti.addEventListener("click", iscriviti);
        ////////////////////////////////////////////////