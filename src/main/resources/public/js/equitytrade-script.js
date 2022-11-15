$(document).ready(function() {
  $.get("http://localhost:8080/bookshop/book/list", function(equitytrades) {
    console.log(equitytrades);
    $("#equitytrades").empty();
    books.forEach(function (equitytrade) {
      console.log(equitytrade);
      let html = "<div class='equitytrade'>";
      html += "Counter Party 1: " + equitytrade.counterParty1.name;
      html += "<br>Counter Party 2: " + equitytrade.counterParty1.name;
      html += "</div>";
      $("#equitytrades").append($(html));
    });
    console.log("Done");
  });
});
