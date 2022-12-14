function generateEquityTable() {
    $(document).ready(function() {
        let getString = "http://localhost:8084/trader/equities";
        let html = "<h4>Equities:</h4>";
        $.get(getString, function(equities) {
            $("#equity-table").empty();
            let table = "<table>";
            table += "<tr>";
            table += "<th>Name</th>";
            table += "<th>Symbol</th>";
            table += "</tr>";
            equities.forEach(function(equity) {
                let tr = "<tr>";
                tr += "<td>" + equity.name + "</td>";
                tr += "<td>" + equity.symbol + "</td>";
                let id = equity.id;
                tr += "</tr>";
                table += tr;
                });
            table += "</table>";
            html += table;
            $("#equity-table").append($(html));
        }).fail(
            function() {
                $("#equity-table").empty();
                console.log("failed");
                html += "<p>No equities registered.</p>";
                $("#equity-table").append($(html));
            });
    });
}

generateEquityTable();

function deleteEquity(id) {
    console.log("Delete equity called on equity with id: " + id);
    let deleteString = "http://localhost:8084/trader/equities/"+id;
    console.log(deleteString);

    $.ajax({
        type: "DELETE",
        url: deleteString,
        success: function() {
            generateEquityTable();
        }
    });
}