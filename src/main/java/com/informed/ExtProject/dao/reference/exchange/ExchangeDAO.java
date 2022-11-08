package com.informed.ExtProject.dao.reference.exchange;

import com.informed.ExtProject.reference.Exchange;

import java.util.List;

public interface ExchangeDAO {

    List<Exchange> getAllExchanges();

    void addExchange(Exchange exchange);
}

