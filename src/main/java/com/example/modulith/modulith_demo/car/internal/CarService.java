package com.example.modulith.modulith_demo.car.internal;

import java.util.List;

import com.example.modulith.modulith_demo.car.CarSaleEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarService {

  private final ApplicationEventPublisher applicationEventPublisher;

  private final CarRepository carRepository;

  List<Car> getCars(String brandName) {
    return carRepository.findAllByBrand(brandName);
  }

  @Transactional
  Car purchaseCar(Long carId, Car car) {
    Car soldCar =
        new Car(
            carId,
            car.brand(),
            car.model(),
            car.description(),
            car.registration(),
            car.mileage(),
            car.cost(),
            "sold");
    applicationEventPublisher.publishEvent(new CarSaleEvent(car.id(), car.brand(), car.cost()));
    return carRepository.save(soldCar);
  }
}
