package com.informed.ExtProject.dao.reference.equity;

import com.informed.ExtProject.reference.Equity;
import com.informed.ExtProject.reference.Equity;
import com.informed.ExtProject.repo.reference.EquityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("repoEquityDAO")
public class RepoEquityDAO implements EquityDAO {

    @Autowired
    private EquityRepo equityRepo;

    public List<Equity> getAllEquities() {
        Iterable<Equity> searchResults = this.equityRepo.findAll();
        List<Equity> equities = new ArrayList<>();
        searchResults.forEach(equities::add);
        return equities;
    }

    @Transactional
    public void addEquity(Equity equity) {
        this.equityRepo.save(equity);
    }

    public Optional<Equity> getEquityById(int id) {
        return this.equityRepo.findById(id);
    }

    @Transactional
    public void removeEquityById(int id) {this.equityRepo.deleteById(id);}

}

