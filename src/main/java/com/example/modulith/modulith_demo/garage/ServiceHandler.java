package com.example.modulith.modulith_demo.garage;

import com.example.modulith.modulith_demo.car.CarSaleEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class ServiceHandler {

  private final ApplicationEventPublisher applicationEventPublisher;

  @ApplicationModuleListener
  void handleCarService(CarSaleEvent carSaleEvent) throws InterruptedException {
    log.info("Inside ServiceHandler with garage for {}", carSaleEvent.brandName());
    Thread.sleep(10000);
    log.info("Finished servicing {} car with id {}", carSaleEvent.brandName(), carSaleEvent.carId());
    applicationEventPublisher.publishEvent(new CarMaintenanceCompletedEvent(carSaleEvent.carId()));
  }
}
