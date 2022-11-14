package com.informed.ExtProject.dao.reference.exchange;

import com.informed.ExtProject.reference.Exchange;

import java.util.List;
import java.util.Optional;

public interface ExchangeDAO {

    List<Exchange> getAllExchanges();

    void addExchange(Exchange exchange);


    Optional<Exchange> getExchangeById(int id);

    void removeExchangeById(int id);
}

