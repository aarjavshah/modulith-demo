package com.example.modulith.modulith_demo.car;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarController {

  private final CarService carService;

  @GetMapping("/cars")
  List<Car> getCars(@RequestParam String brandName) {
    return carService.getCars(brandName);
  }


  @PutMapping("/cars/{carId}")
  Car purchaseCar(@PathVariable("carId") Long carId, @RequestBody Car car) throws InterruptedException {
    return carService.purchaseCar(carId, car);
  }
}
