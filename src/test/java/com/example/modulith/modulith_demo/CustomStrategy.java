package com.example.modulith.modulith_demo;

import org.springframework.modulith.core.ApplicationModuleDetectionStrategy;
import org.springframework.modulith.core.JavaPackage;

import java.util.List;
import java.util.stream.Stream;

public class CustomStrategy implements ApplicationModuleDetectionStrategy {

  private final List<String> MY_MODULES = List.of("car", "garage");

  @Override
  public Stream<JavaPackage> getModuleBasePackages(JavaPackage basePackage) {
    return basePackage.getDirectSubPackages().stream()
        .filter(subPackage -> MY_MODULES.contains(subPackage.getLocalName()));
  }
}
