package com.informed.ExtProject.repo;

import com.informed.ExtProject.domain.CounterParty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterPartyRepo extends CrudRepository<CounterParty, Integer> {
}
