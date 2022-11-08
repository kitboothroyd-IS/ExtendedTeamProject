package com.informed.ExtProject.dao.reference.equity;

import com.informed.ExtProject.reference.Equity;

import java.util.List;

public interface EquityDAO {

    List<Equity> getAllEquities();

    void addEquity(Equity equity);
}
