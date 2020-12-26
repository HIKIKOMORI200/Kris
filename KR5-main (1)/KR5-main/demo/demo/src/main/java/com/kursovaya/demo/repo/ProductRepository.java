package com.kursovaya.demo.repo;

import com.kursovaya.demo.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <Product, Long> {

}
