package com.informed.ExtProject.dao.equityTrade;

import com.informed.ExtProject.domain.CounterParty;
import com.informed.ExtProject.domain.EquityTrade;
import com.informed.ExtProject.repo.EquityTradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional
    public void addEquityTrade(EquityTrade equityTrade) {this.equityTradeRepo.save(equityTrade);}
}
