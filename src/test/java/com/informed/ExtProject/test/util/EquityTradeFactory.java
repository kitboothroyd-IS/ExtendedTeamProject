package com.informed.ExtProject.test.util;

import com.informed.ExtProject.domain.CounterParty;
import com.informed.ExtProject.domain.EquityTrade;
import com.informed.ExtProject.test.util.CounterPartyFactory;
import com.informed.ExtProject.reference.Currency;
import com.informed.ExtProject.reference.Equity;
import com.informed.ExtProject.reference.Exchange;
import com.informed.ExtProject.reference.RefDataTestService;

import java.util.Date;

public class EquityTradeFactory {

    private CounterPartyFactory counterPartyFactory;
    private RefDataTestService refDataTestService;

    private CounterParty counterParty1 = counterPartyFactory.validCounterPartyEmptyPhone();
    private CounterParty counterParty2 = counterPartyFactory.validCounterPartyNullPhone();
    private Date agreementDate = new Date();
    private Equity equity = refDataTestService.validEquity();
    private Currency currency = refDataTestService.validCurrency();
    private Exchange exchange = refDataTestService.validExchange();

    public EquityTradeFactory() {

    }

    public EquityTrade validEquityTrade() {
        EquityTrade equityTrade = new EquityTrade(
                counterParty1,
                counterParty2,
                agreementDate,
                equity,
                0,
                0.0,
                currency,
                exchange
        );
        return equityTrade;
    }

    public EquityTrade invalidEquityTradeIdenticalCounterParties(){
            EquityTrade equityTrade = new EquityTrade(
                    counterParty1,
                    counterParty1,
                    agreementDate,
                    equity,
                    0,
                    0.0,
                    currency,
                    exchange
            );
            return equityTrade;
    }

    public EquityTrade invalidEquityTradeWithNulls(){
        EquityTrade equityTrade = new EquityTrade(
                null,
                null,
                null,
                null,
                0,
                null,
                null,
                null
        );
        return equityTrade;
    }

    public EquityTrade invalidEquityTradeNegativeAmountPrice() {
        EquityTrade equityTrade = new EquityTrade(
                counterParty1,
                counterParty2,
                agreementDate,
                equity,
                -1,
                -1.0,
                currency,
                exchange
        );
        return equityTrade;
    }

}
