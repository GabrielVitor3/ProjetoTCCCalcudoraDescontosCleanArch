document.getElementById("cart-form").addEventListener("submit", function (e) {
    e.preventDefault();

    const inputs = document.querySelectorAll(".quantity");

    const selections = [];

    inputs.forEach(input => {
        const quantity = parseInt(input.value);

        if (quantity && quantity > 0) {
            selections.push({
                productId: parseInt(input.getAttribute("data-id")),
                quantity: quantity
            });
        }
    });

    fetch("/cart", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(selections)
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById("subtotal").innerText = data.subtotal;
            document.getElementById("discount").innerText = data.discount;
            document.getElementById("total").innerText = data.total;
        })
        .catch(error => console.error("Erro:", error));
});