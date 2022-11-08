package com.informed.ExtProject.server.reference;

import com.informed.ExtProject.dao.reference.equity.EquityDAO;
import com.informed.ExtProject.reference.Equity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EquityService {

    private EquityDAO equityDAO;

    @Autowired
    public void setDao(@Qualifier("repoEquityDAO") EquityDAO equityDAO){
        this.equityDAO = equityDAO;
    }

    public List<Equity> getAllEquities() {
        return equityDAO.getAllEquities();
    }

    public void addEquity(Equity equity) {
        equityDAO.addEquity(equity);
    }
}

