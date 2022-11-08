package com.informed.ExtProject.repo.reference;

import com.informed.ExtProject.reference.Exchange;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepo extends CrudRepository<Exchange, Integer> {
}
