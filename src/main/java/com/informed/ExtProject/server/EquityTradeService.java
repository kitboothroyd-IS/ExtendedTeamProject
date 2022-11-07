package com.informed.ExtProject.server;

import com.informed.ExtProject.dao.equityTrade.EquityTradeDAO;
import com.informed.ExtProject.domain.EquityTrade;
import com.informed.ExtProject.exception.NotInListException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
