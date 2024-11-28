package com.example.modulith.modulith_demo.car;

import java.math.BigDecimal;

public record CarSaleEvent(Long carId, String brandName, BigDecimal cost) {}
