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
    showHide("equitytrades");
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
  showHide("form");
}
