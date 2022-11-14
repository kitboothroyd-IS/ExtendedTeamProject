package com.informed.ExtProject.dao.reference.equity;

import com.informed.ExtProject.reference.Equity;

import java.util.List;
import java.util.Optional;

public interface EquityDAO {

    List<Equity> getAllEquities();

    void addEquity(Equity equity);


    Optional<Equity> getEquityById(int id);

    void removeEquityById(int id);
}
