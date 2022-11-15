function showEquityTrades() {
    console.log("Clicked 'View equity trades'.")
    $.get("http://localhost:8084/trader/equitytrades/list",
        function(equitytrades) {
            $("#equitytrades").empty();
            console.log(equitytrades);

            let html = "<div id='equitytrades'>";
            $.each(equitytrades, function(i, equitytrade) {
                console.log(equitytrade);
                html += "<h3 class='title'>Equity trade " + equitytrade.id + ": </h3>";
                html += "<p>";
                html += "Counter Party 1: " + equitytrade.counterParty1.name + "<br>";
                html += "Counter Party 2: " + equitytrade.counterParty2.name + "<br>";
                html += "Agreement date: " + equitytrade.agreementDate + "<br>";
                html += "Equity: " + equitytrade.equity.name + "<br>";
                html += "Amount: " + equitytrade.amount + "<br>";
                html += "Price: " + equitytrade.price + "<br>";
                html += "Currency: " + equitytrade.currency.symbol + "<br>";
                html += "Exchange: " + equitytrade.exchange.name;
                html += "</p>";
            });
            html += "</div";
            $("#equitytrades").append($(html));
    });
    console.log("Finished showing equity trades.");
}

function addEquityTrade() {
  const form = document.getElementById('form');

  if (form.style.display === 'block') {
    form.style.display = 'none';
  } else {
    form.style.display = 'block';
  }
};


    // let obj = $(this).serializeJSON();
    // let data = JSON.stringify(obj);

    // $.ajax({
    // type: "POST",
    // url: "http://localhost:8082/bookshop/addresses",
    // data: data,
    // contentType: "application/json; charset=utf-8",
    // dataType: "json"
    // }
    // );
