$(function () {
	
	console.log("Clicked on submit in registration")
	$("#RegistrationAddressForm").submit(function(event){
		console.log(event);

		let obj = $(this).serializeJSON();
		let data = JSON.stringify(obj);
		console.log(data);

		$.ajax( {
			type: "POST",
			url: "http://localhost:8084/trader/addresses",
			data: data,
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}
		);
        
	});
	
});


function displayAddresses() {
	console.log("clicked show addresses");
	$.get("http://localhost:8084/trader/addresses", 
	function (addresses) {
		$("#addressOptions").empty();

		let html = "<option>";
		$.each(addresses, function (i, address) {
			console.log(address);
			html += address
			// html += "<h1 class='title'>" + address.id + "</h1>";
			// html += "<ul>"
			// html += "<li>number: " + address.number + "</li>";
			// html += "<li>street: " + address.street + "</li>";
			// html += "<li>city: " + address.city + "</li>";
			// html += "<li>county: " + address.county + "</li>";
			// html += "<li>postcode: " + address.postcode + "</li>";
			// html += "</ul>"
		});
		html += "</option>";
		$("#addressOptions").append($(html));
		});
	}