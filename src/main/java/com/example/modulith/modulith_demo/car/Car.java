package com.example.modulith.modulith_demo.car;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

record Car(
    @Id Long id,
    String brand,
    String model,
    String description,
    Long registration,
    Long mileage,
    BigDecimal cost,
    String status) {}
