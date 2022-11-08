package com.informed.ExtProject.repo.reference;

import com.informed.ExtProject.reference.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepo extends CrudRepository<Currency, Integer> {
}
