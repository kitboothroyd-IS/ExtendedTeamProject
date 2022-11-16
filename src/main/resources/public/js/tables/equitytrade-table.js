function generateEquitytradeTable() {
    $(document).ready(function() {
        let getString = "http://localhost:8084/trader/equitytrades/list";
        let html = "<br><h4>Equity Trades:</h4>";
        $.get(getString, function(equitytrades) {
            $("#equitytrade-table").empty();
            let table = "<table>";
            table += "<tr>";
            table += "<th>Counter Party 1</th>";
            table += "<th>Counter Party 2</th>";
            table += "<th>Agreement Date</th>";
            table += "<th>Equity</th>";
            table += "<th>Amount</th>";
            table += "<th>Price</th>";
            table += "<th>Currency</th>";
            table += "<th>Exchange</th>";
            table += "<th></th>";
            table += "</tr>";
            equitytrades.forEach(function(equitytrade) {
                let tr = "<tr>";
                tr += "<td>" + equitytrade.counterParty1.name + "</td>";
                tr += "<td>" + equitytrade.counterParty2.name + "</td>";
                tr += "<td>" + equitytrade.agreementDate + "</td>";
                tr += "<td>" + equitytrade.equity.symbol + "</td>";
                tr += "<td>" + equitytrade.amount + "</td>";
                tr += "<td>" + equitytrade.price + "</td>";
                tr += "<td>" + equitytrade.currency.symbol + "</td>";
                tr += "<td>" + equitytrade.exchange.symbol + "</td>";
                let id = equitytrade.id;
                tr += '<td><button onclick="deleteEquitytrade('+ id + ')">Delete</button></td>';
                tr += "</tr>";
                table += tr;
                });
            table += "</table>";
            html += table;
            $("#equitytrade-table").append($(html));
        }).fail(
            function() {
                $("#equitytrade-table").empty();
                console.log("failed");
                html += "<p>No equity trades registered.</p>";
                $("#equitytrade-table").append($(html));
            });
    });
}

generateEquitytradeTable();

function deleteEquitytrade(id) {
    console.log("Delete equitytrade called on equitytrade with id: " + id);
    let deleteString = "http://localhost:8084/trader/equitytrades/"+id;
    console.log(deleteString);

    $.ajax({
        type: "DELETE",
        url: deleteString,
        success: function() {
            generateEquitytradeTable();
        }
    });
}