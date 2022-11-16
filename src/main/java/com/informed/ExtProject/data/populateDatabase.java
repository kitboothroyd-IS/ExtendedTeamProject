package com.informed.ExtProject.data;

import com.informed.ExtProject.domain.Address;
import com.informed.ExtProject.domain.CounterParty;
import com.informed.ExtProject.domain.EquityTrade;
import com.informed.ExtProject.reference.Currency;
import com.informed.ExtProject.reference.Equity;
import com.informed.ExtProject.reference.Exchange;
import com.informed.ExtProject.reference.ForeignExchangeRate;
import com.informed.ExtProject.repo.reference.CurrencyRepo;
import com.informed.ExtProject.server.domain.AddressService;
import com.informed.ExtProject.server.domain.CounterPartyService;
import com.informed.ExtProject.server.domain.EquityTradeService;
import com.informed.ExtProject.server.reference.CurrencyService;
import com.informed.ExtProject.server.reference.EquityService;
import com.informed.ExtProject.server.reference.ExchangeService;
import com.informed.ExtProject.server.reference.ForeignExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static java.time.LocalDate.parse;


@Component
public class populateDatabase implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private EquityService equityService;

    @Autowired
    private ExchangeService exchangeService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CounterPartyService counterPartyService;

    @Autowired
    private EquityTradeService equityTradeService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        addCurrenciesAndForeignExchange();
        addEquities();
        addExchanges();
        addEquityTrade();
    }

    public void addCurrenciesAndForeignExchange() {
        Currency gbp = new Currency("Sterling","GBP");
        Currency usd = new Currency("United States Dollars","USD");
        Currency eur = new Currency("Euros","EUR");
        Currency yen = new Currency("Japanese Yen","YEN");
        Currency aud = new Currency("Australian Dollar","AUD");
        Currency nzd = new Currency("New Zealand Dollar","NZD");

        currencyService.addCurrency(gbp);
        currencyService.addCurrency(usd);
        currencyService.addCurrency(eur);
        currencyService.addCurrency(yen);
        currencyService.addCurrency(aud);
        currencyService.addCurrency(nzd);

        ForeignExchangeRate gbpUsd = new ForeignExchangeRate(gbp, usd, 1.34);
        ForeignExchangeRate gbpEur = new ForeignExchangeRate(gbp, eur, 1.1);
        ForeignExchangeRate gbpYen = new ForeignExchangeRate(gbp, usd, 2);
        ForeignExchangeRate gbpAud = new ForeignExchangeRate(gbp, usd, 1.8);
        ForeignExchangeRate gbpNzd = new ForeignExchangeRate(gbp, usd, 1.9);

        ForeignExchangeRate usdEur = new ForeignExchangeRate(usd, eur, 0.9);
        ForeignExchangeRate usdYen = new ForeignExchangeRate(usd, yen, 3);
        ForeignExchangeRate usdAud = new ForeignExchangeRate(usd, aud, 0.85);
        ForeignExchangeRate usdNzd = new ForeignExchangeRate(usd, nzd, 0.9);

        ForeignExchangeRate eurYen = new ForeignExchangeRate(eur, yen, 1.5);
        ForeignExchangeRate eurAud = new ForeignExchangeRate(eur, aud, 1.1);
        ForeignExchangeRate eurNzd = new ForeignExchangeRate(eur, nzd, 1.2);

        ForeignExchangeRate yenAud = new ForeignExchangeRate(yen, aud, 1.4);
        ForeignExchangeRate yenNzd = new ForeignExchangeRate(yen, nzd, 1.5);

        ForeignExchangeRate audNzd = new ForeignExchangeRate(aud, nzd, 1.1);

        ForeignExchangeRateService.AddExchangeRate(gbpAud);
        ForeignExchangeRateService.AddExchangeRate(gbpEur);
        ForeignExchangeRateService.AddExchangeRate(gbpYen);
        ForeignExchangeRateService.AddExchangeRate(gbpUsd);
        ForeignExchangeRateService.AddExchangeRate(gbpNzd);
        ForeignExchangeRateService.AddExchangeRate(usdEur);
        ForeignExchangeRateService.AddExchangeRate(usdYen);
        ForeignExchangeRateService.AddExchangeRate(usdAud);
        ForeignExchangeRateService.AddExchangeRate(usdNzd);
        ForeignExchangeRateService.AddExchangeRate(eurYen);
        ForeignExchangeRateService.AddExchangeRate(eurAud);
        ForeignExchangeRateService.AddExchangeRate(eurNzd);
        ForeignExchangeRateService.AddExchangeRate(yenAud);
        ForeignExchangeRateService.AddExchangeRate(yenNzd);
        ForeignExchangeRateService.AddExchangeRate(audNzd);

    }

    public void addEquities() {
        Equity goog = new Equity("Google", "GOOG");
        Equity msft = new Equity("Microsoft", "MSFT");
        Equity ibm = new Equity("IBM INC.", "IBM");
        Equity unl = new Equity("Unilever", "UNL");
        Equity lgen = new Equity("Legal and general", "LGEN");

        equityService.addEquity(goog);
        equityService.addEquity(msft);
        equityService.addEquity(ibm);
        equityService.addEquity(unl);
        equityService.addEquity(lgen);

    }

    public void addExchanges() {
        Exchange lse = new Exchange("London Stock Exchange", "LSE");
        Exchange nyse = new Exchange("New York Stock Exchange", "NYSE");
        Exchange hkse = new Exchange("Hong Kong Stock Exchange", "HKSE");
        Exchange sse = new Exchange("Shanghai Stock Exchange", "SSE");
        Exchange tse = new Exchange("Tokyo Stock Exchange", "TSE");

        exchangeService.addExchange(lse);
        exchangeService.addExchange(nyse);
        exchangeService.addExchange(hkse);
        exchangeService.addExchange(sse);
        exchangeService.addExchange(tse);
    }

    public void addEquityTrade() {
        Address addressCp1 = new Address("10 South Street", "Tawa", "Wellington", "6021");
        Address addressCp2 = new Address("20 Low Street", "Newtown", "Wellington", "6011");
        addressService.addAddress(addressCp1);
        addressService.addAddress(addressCp2);

        CounterParty cp1 = new CounterParty("Aaron", "+447248274859", "aaron@informed.com", addressCp1);
        CounterParty cp2 = new CounterParty("Kit", "+447256783566", "kit@informed.com", addressCp2);
        counterPartyService.addCounterParty(cp1);
        counterPartyService.addCounterParty(cp2);

        String dateString = "22/11/2010";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dateString, formatter);
        System.out.println(date);

        Equity equity = equityService.getAllEquities().get(0);
        Currency currency = currencyService.getAllCurrencies().get(0);
        Exchange exchange = exchangeService.getAllExchanges().get(0);

        EquityTrade equityTrade = new EquityTrade(cp1,
                cp2,
                date,
                equity,
                100,
                54.0,
                currency,
                exchange);

        equityTradeService.addEquityTrade(equityTrade);
}

}
