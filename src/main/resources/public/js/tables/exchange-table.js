function generateExchangeTable() {
    $(document).ready(function() {
        let getString = "http://localhost:8084/trader/exchanges";
        let html = "<h4>Exchanges:</h4>";
        $.get(getString, function(exchanges) {
            $("#exchange-table").empty();
            let table = "<table>";
            table += "<tr>";
            table += "<th>Name</th>";
            table += "<th>Symbol</th>";
            table += "</tr>";
            exchanges.forEach(function(exchange) {
                let tr = "<tr>";
                tr += "<td>" + exchange.name + "</td>";
                tr += "<td>" + exchange.symbol + "</td>";
                let id = exchange.id;
                tr += "</tr>";
                table += tr;
                });
            table += "</table>";
            html += table;
            $("#exchange-table").append($(html));
        }).fail(
            function() {
                $("#exchange-table").empty();
                console.log("failed");
                html += "<h3>No exchanges registered.</h3>";
                $("#exchange-table").append($(html));
            });
    });
}

generateExchangeTable();

function deleteExchange(id) {
    console.log("Delete exchange called on exchange with id: " + id);
    let deleteString = "http://localhost:8084/trader/exchanges/"+id;
    console.log(deleteString);

    $.ajax({
        type: "DELETE",
        url: deleteString,
        success: function() {
            generateExchangeTable();
        }
    });
}