package com.example.modulith.modulith_demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class ModulithDemoApplicationTests {
  ApplicationModules modules = ApplicationModules.of(ModulithDemoApplication.class);

  @Test
  void generateDocumentation() {
    new Documenter(modules).writeDocumentation();
  }

  @Test
  void verifiesModularStructure() {
    modules.verify();
  }
}
