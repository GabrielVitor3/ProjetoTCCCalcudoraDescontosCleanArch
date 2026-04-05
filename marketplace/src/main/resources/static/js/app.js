document.getElementById("cart-form").addEventListener("submit", function (e) {
    e.preventDefault();

    const inputs = document.querySelectorAll(".quantity");
    const selecoes = [];

    inputs.forEach(input => {
        const valor = input.value.trim();

        if (valor !== "") {
            const quantidade = parseInt(valor);

            if (!isNaN(quantidade) && quantidade > 0) {
                selecoes.push({
                    idProduto: parseInt(input.getAttribute("data-id")),
                    quantidade: quantidade
                });
            }
        }
    });

    console.log("Enviando:", JSON.stringify(selecoes, null, 2));

    fetch("/cart", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(selecoes)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro na requisição: " + response.status);
            }
            return response.json();
        })
        .then(data => {
            console.log("Resposta da API:", data);

            document.getElementById("subtotal").innerText = data.subtotal ?? "0";
            document.getElementById("discount").innerText = data.desconto ?? "0";
            document.getElementById("total").innerText = data.total ?? "0";
        })
        .catch(error => {
            console.error("Erro:", error);
            document.getElementById("subtotal").innerText = "Erro";
            document.getElementById("discount").innerText = "Erro";
            document.getElementById("total").innerText = "Erro";
        });
});