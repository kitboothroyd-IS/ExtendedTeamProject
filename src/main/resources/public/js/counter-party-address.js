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