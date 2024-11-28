package com.example.modulith.modulith_demo.car;

import java.util.List;
import org.springframework.data.repository.ListCrudRepository;

interface CarRepository extends ListCrudRepository<Car, Long> {

  List<Car> findAllByBrand(String brand);
}
