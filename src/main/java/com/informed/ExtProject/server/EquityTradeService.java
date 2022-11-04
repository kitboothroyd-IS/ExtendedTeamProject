package com.informed.ExtProject.server;

import com.informed.ExtProject.domain.EquityTrade;
import com.informed.ExtProject.exception.NotInListException;

import java.util.ArrayList;
import java.util.List;

public class EquityTradeService {
    private static List<EquityTrade> equityTradeList = new ArrayList<EquityTrade>();

    public static void addEquityTrade(EquityTrade equityTrade) {
        equityTradeList.add(equityTrade);
    }

    public static void deleteEquityTrade(EquityTrade equityTrade) {
        if (!equityTradeList.contains(equityTrade)) {
            throw new NotInListException("equity trade");
        }
        equityTradeList.remove(equityTrade);
    }
}
