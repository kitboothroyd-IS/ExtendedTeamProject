//console.log("JS LOADED");

$.get("http://localhost:8084/trader/addresses/list",
	function (addresses) {
		//console.log(addresses);
		$("#addressOptions").empty();
		let html = "<select>"
		$.each(addresses, function (i, address) {
			console.log(address);
			let option = "<option>";
			option += address.line1 + ", " + address.line2 + ", "+ address.line3 + ", " + address.city + ", "+ address.county + ", " + address.postcode;
			option += "</option>";
			html += option;
		});
		html += "</select>";
		$("#addressList").append($(html));
	}
);


$(function () {
	
	console.log("Clicked on submit in registration")
	$("#RegistrationDetailsForm").submit(function(event){
		console.log(event);

		let obj = $(this).serializeJSON();
		let data = JSON.stringify(obj);
		alert(data);

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