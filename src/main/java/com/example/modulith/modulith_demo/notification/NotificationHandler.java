package com.example.modulith.modulith_demo.notification;

import com.example.modulith.modulith_demo.invoice.InvoiceCreatedEvent;
import com.example.modulith.modulith_demo.garage.CarMaintenanceCompletedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class NotificationHandler {

  @ApplicationModuleListener
  void handleNotifications(CarMaintenanceCompletedEvent carMaintenanceCompletedEvent) {
    log.info(
        "Inside NotificationModule for notifying for car service completed {}", carMaintenanceCompletedEvent);
    log.info(
        "Your car is ready for pickup. Please don't forget to pay the invoice for smooth delivery.");
  }

  @ApplicationModuleListener
  void handleNotifications(InvoiceCreatedEvent invoiceCreatedEvent) {
    log.info("Inside NotificationModule for generated invoice for order {}", invoiceCreatedEvent);
    log.info("You have an outstanding invoice for payment.");
  }
}
