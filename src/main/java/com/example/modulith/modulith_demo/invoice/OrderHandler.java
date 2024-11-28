package com.example.modulith.modulith_demo.invoice;

import com.example.modulith.modulith_demo.car.CarSaleEvent;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class OrderHandler {

  private final ApplicationEventPublisher applicationEventPublisher;

  @ApplicationModuleListener
  void createInvoice(CarSaleEvent carSaleEvent) throws InterruptedException {
    log.info("Inside invoice generator for {}", carSaleEvent);
    Thread.sleep(3000);
    log.info("Finished generating invoice for {}", carSaleEvent);
    applicationEventPublisher.publishEvent(
        new InvoiceCreatedEvent(carSaleEvent.carId(), UUID.randomUUID().toString()));
  }
}
