package com.informed.ExtProject.repo.domain;

import com.informed.ExtProject.domain.EquityTrade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquityTradeRepo extends CrudRepository<EquityTrade, Integer> {
}
