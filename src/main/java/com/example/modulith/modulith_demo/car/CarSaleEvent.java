package com.example.modulith.modulith_demo.car;

import org.springframework.modulith.events.Externalized;

import java.math.BigDecimal;

@Externalized("new-car-registration::#{carId()}")
public record CarSaleEvent(Long carId, String brandName, BigDecimal cost) {}
