

function showEquityTrades() {
    console.log("Clicked 'View equity trades'.")
    $.get("http://localhost:8084/trader/equitytrades/list",
        function(equitytrades) {
            $("#equitytrades").empty();
            console.log(equitytrades);

            let html = "<div class='equitytrades'";
            $.each(equitytrades, function(i, equitytrade) {
                console.log(equitytrade);
                html += "Counter Party 1: " + equitytrade.CounterParty1;
                html += "<br />Counter Party 2: " + equitytrade.counterParty2.name;
                html += "<br />Agreement date: " + equitytrade.agreementDate;
                html += "<br />Equity: " + equitytrade.equity.name;
                html += "<br />Amount: " + equitytrade.amount;
                html += "<br />Price: " + equitytrade.price;
                html += "<br />Currency: " + equitytrade.currency.symbol;
                html += "<br />Exchange: " + equitytrade.exchange.name;
            })
            html += "</div";
            $("equitytrades").append($(html));
    });
    console.log("Finished showing equity trades.");
}
