function generateAddressTable() {
    $(document).ready(function() {
        let getString = "http://localhost:8084/trader/addresses/list";
        let html = "<h2>Addresses:</h2>";
        $.get(getString, function(addresses) {
            $("#address-table").empty();
            let table = "<table>";
            table += "<tr>";
            table += "<th>Line 1</th>";
            table += "<th>Line 2</th>";
            table += "<th>Line 3</th>";
            table += "<th>City</th>";
            table += "<th>County</th>";
            table += "<th>Postcode</th>";
            table += "</tr>";
            addresses.forEach(function(address) {
                let tr = "<tr>";
                tr += "<td>" + address.line1 + "</td>";
                tr += "<td>" + address.line2 + "</td>";
                tr += "<td>" + address.line3 + "</td>";
                tr += "<td>" + address.city + "</td>";
                tr += "<td>" + address.county + "</td>";
                tr += "<td>" + address.postcode + "</td>";
                let id = address.id;
                tr += '<td><button onclick="deleteAddress('+ id + ')">Delete</button></td>';
                tr += "</tr>";
                table += tr;
                });
            table += "</table>";
            html += table;
            $("#address-table").append($(html));
        }).fail(
            function() {
                $("#address-table").empty();
                console.log("failed");
                html += "<h3>No addresses registered.</h3>";
                $("#address-table").append($(html));
            });
    });
}

generateAddressTable();

function deleteAddress(id) {
    console.log("Delete address called on address with id: " + id);
    let deleteString = "http://localhost:8084/trader/addresses/"+id;
    console.log(deleteString);

    $.ajax({
        type: "DELETE",
        url: deleteString,
        success: function() {
            generateAddressTable();
        }
    });
}