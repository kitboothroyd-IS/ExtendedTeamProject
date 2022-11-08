package com.informed.ExtProject.server.domain;

import com.informed.ExtProject.dao.domain.equityTrade.EquityTradeDAO;
import com.informed.ExtProject.domain.EquityTrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EquityTradeService {
    private EquityTradeDAO equityTradeDAO;

    @Autowired
    public void setDao(@Qualifier("repoEquityTradeDAO") EquityTradeDAO equityTradeDAO) {
        this.equityTradeDAO = equityTradeDAO;
    }

    public List<EquityTrade> getAllEquityTrades() {
        return equityTradeDAO.getAllEquityTrades();
    }

    public void addEquityTrade(EquityTrade equityTrade) {
        equityTradeDAO.addEquityTrade(equityTrade);
    }
}
