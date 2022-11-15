$(document).ready(function() {
    $.get("http://localhost:8084/trader/counterparties/list", function(counterparties) {
        $("#counterparties").empty();
        let html = "<h2>Counter Parties:</h2>"
        let table = "<table>";
        table += "<tr>";
        table += "<th>Name</th>";
        table += "<th>Phone Number</th>";
        table += "<th>Email Address</th>";
        table += "<th>Postcode</th>";
        table += "</tr>";
        counterparties.forEach(function (counterparty) {
            let tr = "<tr>";
            tr += "<td>" + counterparty.name + "</td>";
            tr += "<td>" + counterparty.phoneNumber + "</td>";
            tr += "<td>" + counterparty.emailAddress + "</td>";
            tr += "<td>" + counterparty.address.postcode + "</td>";
            tr += "</tr>";
            table += tr;
            });
        table += "</table>";
        html += table;
        $("#counterparties").append($(html));
    });
});