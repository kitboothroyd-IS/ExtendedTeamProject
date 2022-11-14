package com.informed.ExtProject.dao.domain.equityTrade;

import com.informed.ExtProject.domain.EquityTrade;

import java.util.List;
import java.util.Optional;

public interface EquityTradeDAO {

  List<EquityTrade> getAllEquityTrades();

  Optional<EquityTrade> getEquityTradeById(int id);

  void addEquityTrade(EquityTrade equityTrade);

  Optional<EquityTrade> updateEquityTrade(EquityTrade equityTrade);

  void removeEquityTrade(EquityTrade equityTrade);

  void removeEquityTradeById(int id);


}
