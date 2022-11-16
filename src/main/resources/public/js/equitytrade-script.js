function showHide(docId) {
  const doc = document.getElementById(docId);
  if (doc.style.display === 'block') {
    doc.style.display = 'none';
  } else {
    doc.style.display = 'block';
};
}

function showEquityTrades() {
    console.log("Clicked 'View equity trades'.")
    showHide("equitytrade-table");
}

function addEquityTrades() {
  console.log("Clicked 'Add equity trade'.")
  showHide("ETRegistrationDetailsForm");
}

// Create a drop-down menu for counterparties
let counterpartyList = [];

$.get("http://localhost:8084/trader/counterparties/list",
	function (counterparties) {
		counterpartyList = counterparties;
		//console.log(counterparties);
		$(".counterpartyOptions").empty();
		let html = "";
		$.each(counterparties, function (i, counterparty) {
			console.log(counterparty);
			let option = "<option value=" + counterparty.id + ">";
			option += counterparty.name + ", ";
      option += counterparty.phoneNumber + ", "; 
      option += counterparty.emailAddress + ", "; 
      option += "address: " + counterparty.address.line1 + ", " + counterparty.address.city  + ", " + counterparty.address.postcode;
			option += "</option>";
			html += option;
		});
		// html += "</select>";
		$(".counterpartyOptions").append($(html));
	}
);

let equityList = [];

$.get("http://localhost:8084/trader/equities",
	function (equities) {
		equityList = equities;
		//console.log(equities);
		$("#equityOptions").empty();
		let html = "<br>";
		$.each(equities, function (i, equity) {
			console.log(equity);
			let option = "<option value=" + equity.id + ">";
			option += equity.name;
			option += "</option>";
			html += option;
		});
		// html += "</select>";
		$("#equityOptions").append($(html));
	}
);

let currencyList = [];

$.get("http://localhost:8084/trader/currencies",
	function (currencies) {
		currencyList = currencies;
		//console.log(currencies);
		$("#currencyOptions").empty();
		let html = "<br>";
		$.each(currencies, function (i, currency) {
			console.log(currency);
			let option = "<option value=" + currency.id + ">";
			option += currency.symbol;
			option += "</option>";
			html += option;
		});
		// html += "</select>";
		$("#currencyOptions").append($(html));
	}
);

let exchangeList = [];

$.get("http://localhost:8084/trader/exchanges",
	function (exchanges) {
		exchangeList = exchanges;
		//console.log(exchanges);
		$("#exchangeOptions").empty();
		let html = "<br>";
		$.each(exchanges, function (i, exchange) {
			console.log(exchange);
			let option = "<option value=" + exchange.id + ">";
			option += exchange.name;
			option += "</option>";
			html += option;
		});
		// html += "</select>";
		$("#exchangeOptions").append($(html));
	}
);

function addEquityTrade() {
  showHide("ETRegistrationDetailsForm");
}


$(function () {
	
	console.log("Adding registration details.")
	$("#ETRegistrationDetailsForm").submit(function(event){
		console.log(event);

		let obj = $(this).serializeJSON();

    // Retrieve counter party objects
		const counterParty1Id = obj['counterparty1'];
    const counterParty2Id = obj['counterparty2'];

		let cp1Lookup = '';
    let cp2Lookup = '';
		for (let i =0; i < counterpartyList.length; i++) {
			if (counterpartyList[i].id == counterParty1Id) {
				cp1Lookup = counterpartyList[i];
			}
			if (counterpartyList[i].id == counterParty2Id) {
				cp2Lookup = counterpartyList[i];
		}
  }

		obj['counterparty1'] = cp1Lookup;
		obj['counterparty2'] = cp2Lookup;

    // Retrieve equity object
    const equityId = obj['equity'];

		let equityLookup = '';
		for (let i =0; i < equityList.length; i++) {
			if (equityList[i].id == equityId) {
				equityLookup = equityList[i];
			}
    }

		obj['equity'] = equityLookup;

    // Retrieve currency object
    const currencyId = obj['currency'];

		let currencyLookup = '';
		for (let i =0; i < currencyList.length; i++) {
			if (currencyList[i].id == currencyId) {
				currencyLookup = currencyList[i];
			}
    }

		obj['currency'] = currencyLookup;

    // Retrieve exchange object
    const exchangeId = obj['exchange'];

		let exchangeLookup = '';
		for (let i =0; i < exchangeList.length; i++) {
			if (exchangeList[i].id == exchangeId) {
				exchangeLookup = exchangeList[i];
			}
    }

		obj['exchange'] = exchangeLookup;
		
		let data = JSON.stringify(obj);

		$.ajax( {
			type: "POST",
			url: "http://localhost:8084/trader/equitytrades",
			data: data,
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		});
  });
});