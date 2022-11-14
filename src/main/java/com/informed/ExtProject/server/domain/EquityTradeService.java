package com.informed.ExtProject.server.domain;

import com.informed.ExtProject.dao.domain.equityTrade.EquityTradeDAO;
import com.informed.ExtProject.domain.EquityTrade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

  public Optional<EquityTrade> getEquityTradeById(int id) {
    return equityTradeDAO.getEquityTradeById(id);
  }
  public void addEquityTrade(EquityTrade equityTrade) {
    equityTradeDAO.addEquityTrade(equityTrade);
  }

  public Optional<EquityTrade> updateEquityTrade(EquityTrade equityTrade) {
    return equityTradeDAO.updateEquityTrade(equityTrade);
  }

  public void removeEquityTrade(EquityTrade equityTrade) {
    equityTradeDAO.removeEquityTrade(equityTrade);
  }

  public void removeEquityTradeById(int id) {
    equityTradeDAO.removeEquityTradeById(id);
  }
}