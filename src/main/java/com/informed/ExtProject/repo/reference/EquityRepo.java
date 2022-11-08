package com.informed.ExtProject.repo.reference;

import com.informed.ExtProject.reference.Equity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquityRepo extends CrudRepository<Equity, Integer> {
}
