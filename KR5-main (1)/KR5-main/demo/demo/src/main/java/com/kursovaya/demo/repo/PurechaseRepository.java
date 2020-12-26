package com.kursovaya.demo.repo;

import com.kursovaya.demo.models.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurechaseRepository extends CrudRepository<Purchase, Long> {
}
