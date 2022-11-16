//console.log("JS LOADED");

let address_list = [];

$.get("http://localhost:8084/trader/addresses/list",
	function (addresses) {
		address_list = addresses;
		//console.log(addresses);
		$("#addressOptions").empty();
		let html = ""
		$.each(addresses, function (i, address) {
			console.log(address);
			let option = "<option value=" + address.id + ">";
			option += address.line1 + ", " + address.line2 + ", "+ address.line3 + ", " + address.city + ", "+ address.county + ", " + address.postcode;
			option += "</option>";
			html += option;
		});
		// html += "</select>";
		$("#addressOptions").append($(html));
	}
);


$(function () {
	
	console.log("Clicked on submit in registration")
	$("#RegistrationDetailsForm").submit(function(event){
		console.log(event);

		let obj = $(this).serializeJSON();
		const address_id = obj['address'];

		let address_lookup = '';
		// look up the address id in the list of address
		for (let i =0; i < address_list.length; i++) {
			if (address_list[i].id == address_id) {
				address_lookup = address_list[i];
			}
		}

		obj['address'] = address_lookup;

		
		let data = JSON.stringify(obj);
		// alert(data);

		$.ajax( {
			type: "POST",
			url: "http://localhost:8084/trader/counterparties",
			data: data,
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}
		);
        
	});
	
});


function showCounterParties() {
    console.log("Clicked 'View Counter Parties'.")
    $.get("http://localhost:8084/trader/counterparties/list",
        function(counterParties) {
            $("#counterPartiesList").empty();
            console.log(counterParties);

            let html = "<div id='counterPartiesList'>";
            $.each(counterParties, function(i, counterParty) {
                console.log(counterParty);
                html += "<h3 class='title'>Counter Party " + counterParty.id + ": </h3>";
                html += "<p>";
                html += "Name: " + counterParty.name + "<br>";
                html += "Phone Number: " + counterParty.phoneNumber + "<br>";
                html += "Email Address: " + counterParty.emailAddress + "<br>";
                html += "<label>Address: </label>Line 1:" + counterParty.address.line1 + "<br>";
                html += "Line 2: " + counterParty.address.line2 + "<br>";
                html += "Line 3: " + counterParty.address.line3 + "<br>";
                html += "City: " + counterParty.address.city + "<br>";
				html += "County: " + counterParty.address.county + "<br>";
                html += "Postcode: " + counterParty.address.postcode;
                html += "</p>";
            });
            html += "</div";
            $("#counterPartiesList").append($(html));
    });
    console.log("Finished showing Counter Parties.");
}