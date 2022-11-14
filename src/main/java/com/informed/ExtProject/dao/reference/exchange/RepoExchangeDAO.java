package com.informed.ExtProject.dao.reference.exchange;

import com.informed.ExtProject.reference.Exchange;
import com.informed.ExtProject.reference.Exchange;
import com.informed.ExtProject.repo.reference.ExchangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("repoExchangeDAO")
public class RepoExchangeDAO implements ExchangeDAO {

    @Autowired
    private ExchangeRepo exchangeRepo;

    public List<Exchange> getAllExchanges() {
        Iterable<Exchange> searchResults = this.exchangeRepo.findAll();
        List<Exchange> exchanges = new ArrayList<>();
        searchResults.forEach(exchanges::add);
        return exchanges;
    }

    @Transactional
    public void addExchange(Exchange exchange) {
        this.exchangeRepo.save(exchange);
    }

    public Optional<Exchange> getExchangeById(int id) {
        return this.exchangeRepo.findById(id);
    }

    @Transactional
    public void removeExchangeById(int id) {this.exchangeRepo.deleteById(id);}

}

