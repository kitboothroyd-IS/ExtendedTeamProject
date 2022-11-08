package com.informed.ExtProject.dao.domain.equityTrade;

import com.informed.ExtProject.domain.CounterParty;
import com.informed.ExtProject.domain.EquityTrade;

import java.util.List;

public interface EquityTradeDAO {

    List<EquityTrade> getAllEquityTrades();

    void addEquityTrade(EquityTrade equityTrade);
}
