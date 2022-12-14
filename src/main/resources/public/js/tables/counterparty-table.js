function generateCounterPartyTable() {
    $(document).ready(function() {
        let getString = "http://localhost:8084/trader/counterparties/list";
        let html = "<h4>Counter Parties:</h4>";
        $.get(getString, function(counterparties) {
            $("#counterparty-table").empty();
            let table = "<table>";
            table += "<tr>";
            table += "<th>Name</th>";
            table += "<th>Phone Number</th>";
            table += "<th>Email Address</th>";
            table += "<th>Postcode</th>";
            table += "<th></th>";
            table += "</tr>";
            counterparties.forEach(function(counterparty) {
                let tr = "<tr>";
                tr += "<td>" + counterparty.name + "</td>";
                tr += "<td>" + counterparty.phoneNumber + "</td>";
                tr += "<td>" + counterparty.emailAddress + "</td>";
                tr += "<td>" + counterparty.address.postcode + "</td>";
                let id = counterparty.id;
                tr += '<td><button class="btn" onclick="deleteCounterParty('+ id + ')">Delete</button></td>';
                tr += "</tr>";
                table += tr;
                });
            table += "</table>";
            html += table;
            $("#counterparty-table").append($(html));
        }).fail(
            function() {
                $("#counterparty-table").empty();
                console.log("failed");
                html += "<h3>No counter parties registered.</h3>";
                $("#counterparty-table").append($(html));
            });
    });
}

generateCounterPartyTable();

function deleteCounterParty(id) {
    console.log("Delete counter party called on counter party with id: " + id);
    let deleteString = "http://localhost:8084/trader/counterparties/"+id;
    console.log(deleteString);

    $.ajax({
        type: "DELETE",
        url: deleteString,
        success: function() {
            generateCounterPartyTable();
        }
    }).fail(function(){
        alert("You cannot delete this counter party because it relates to a registered equity trade.");
    });
}