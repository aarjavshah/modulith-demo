package com.example.modulith.modulith_demo.garage;

import com.example.modulith.modulith_demo.car.CarSaleEvent;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.modulith.test.Scenario;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ApplicationModuleTest
class ServiceModuleTest {

    @Test
    void testServiceHandler(Scenario scenario) {
        var carMaintenanceCompletedEvent = new CarMaintenanceCompletedEvent(1L);
        scenario.publish(new CarSaleEvent(1L, "BMW", BigDecimal.ONE))
                .andWaitForEventOfType(CarMaintenanceCompletedEvent.class)
                .toArriveAndVerify(event -> assertEquals(carMaintenanceCompletedEvent, event));
    }

}
