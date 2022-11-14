package com.informed.ExtProject.dao.domain.equityTrade;

import com.informed.ExtProject.domain.EquityTrade;
import com.informed.ExtProject.repo.domain.EquityTradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("repoEquityTradeDAO")
public class RepoEquityTradeDAO implements EquityTradeDAO{

    @Autowired
    private EquityTradeRepo equityTradeRepo;

    public List<EquityTrade> getAllEquityTrades() {
        Iterable<EquityTrade> searchResults = this.equityTradeRepo.findAll();
        List<EquityTrade> equityTrades = new ArrayList<>();
        searchResults.forEach(equityTrades::add);
        return equityTrades;
    }

    public Optional<EquityTrade> getEquityTradeById(int id) {
        return this.equityTradeRepo.findById(id);
    }

    @Transactional
    public void addEquityTrade(EquityTrade equityTrade) {
        this.equityTradeRepo.save(equityTrade);
        System.out.println("Added Equity Trade: " + equityTrade);
    }

    @Transactional
    public Optional<EquityTrade> updateEquityTrade(EquityTrade equityTrade) {
        int equityTradeId = equityTrade.getId();
        return this.equityTradeRepo.findById(equityTradeId).map(dbEquityTrade -> {
            dbEquityTrade.setCounterParty1(equityTrade.getCounterParty1());
            dbEquityTrade.setCounterParty2(equityTrade.getCounterParty2());
            dbEquityTrade.setAgreementDate(equityTrade.getAgreementDate());
            dbEquityTrade.setEquity(equityTrade.getEquity());
            dbEquityTrade.setAmount(equityTrade.getAmount());
            dbEquityTrade.setPrice(equityTrade.getPrice());
            dbEquityTrade.setCurrency(equityTrade.getCurrency());
            dbEquityTrade.setExchange(equityTrade.getExchange());
            return dbEquityTrade;
        });
    }

    @Transactional
    public void removeEquityTrade(EquityTrade equityTrade) {
        this.equityTradeRepo.delete(equityTrade);
        System.out.println("Deleted Equity Trade: " + equityTrade);
    }

    @Transactional
    public void removeEquityTradeById(int id) {
        this.equityTradeRepo.deleteById(id);
        System.out.println("Deleted Equity Trade with ID: " + id);
    }


}
