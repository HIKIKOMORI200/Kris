package com.kursovaya.demo.repo;

import com.kursovaya.demo.models.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository <ShoppingCart, Long> {
}
