package com.informed.ExtProject.server.reference;

import com.informed.ExtProject.dao.reference.exchange.ExchangeDAO;
import com.informed.ExtProject.reference.Exchange;
import com.informed.ExtProject.reference.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ExchangeService {

    private ExchangeDAO exchangeDAO;

    @Autowired
    public void setDao(@Qualifier("repoExchangeDAO") ExchangeDAO exchangeDAO){
        this.exchangeDAO = exchangeDAO;
    }

    public List<Exchange> getAllExchanges() {
        return exchangeDAO.getAllExchanges();
    }

    public void addExchange(Exchange exchange) {
        exchangeDAO.addExchange(exchange);
    }

    public Optional<Exchange> getExchangeById(int id) {
        return exchangeDAO.getExchangeById(id);
    }

    public void removeExchangeById(int id) {
        exchangeDAO.removeExchangeById(id);
    }
}
