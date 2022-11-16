function generateCurrencyTable() {
    $(document).ready(function() {
        let getString = "http://localhost:8084/trader/currencies";
        let html = "<h4>Currencies:</h4>";
        $.get(getString, function(currencies) {
            $("#currency-table").empty();
            let table = "<table>";
            table += "<tr>";
            table += "<th>Name</th>";
            table += "<th>Symbol</th>";
            table += "</tr>";
            currencies.forEach(function(currency) {
                let tr = "<tr>";
                tr += "<td>" + currency.name + "</td>";
                tr += "<td>" + currency.symbol + "</td>";
                let id = currency.id;
                tr += "</tr>";
                table += tr;
                });
            table += "</table>";
            html += table;
            $("#currency-table").append($(html));
        }).fail(
            function() {
                $("#currency-table").empty();
                console.log("failed");
                html += "<h3>No currencies registered.</h3>";
                $("#currency-table").append($(html));
            });
    });
}

generateCurrencyTable();

function deleteCurrency(id) {
    console.log("Delete currency called on currency with id: " + id);
    let deleteString = "http://localhost:8084/trader/currencies/"+id;
    console.log(deleteString);

    $.ajax({
        type: "DELETE",
        url: deleteString,
        success: function() {
            generateCurrencyTable();
        }
    });
}