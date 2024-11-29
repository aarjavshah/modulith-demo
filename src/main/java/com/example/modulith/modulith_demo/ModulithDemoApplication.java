package com.example.modulith.modulith_demo;

import com.example.modulith.modulith_demo.car.CarSaleEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.ssl.DefaultSslBundleRegistry;
import org.springframework.boot.ssl.SslBundles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.modulith.events.EventExternalizationConfiguration;
import org.springframework.modulith.events.RoutingTarget;

import java.util.Objects;

@SpringBootApplication
public class ModulithDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(ModulithDemoApplication.class, args);
  }
/*
  @Bean
  EventExternalizationConfiguration eventExternalizationConfiguration() {
    return EventExternalizationConfiguration.externalizing()
            .select(EventExternalizationConfiguration.annotatedAsExternalized())
            .route(
                    CarSaleEvent.class,
                    it -> RoutingTarget.forTarget("new-car-registration").andKey(it.carId().toString())
            )
            .mapping(
                    CarSaleEvent.class,
                    it -> new PostPublishedKafkaEvent(it.carId().toString(), it.brandName(), it.cost().toString())
            )
            .build();
  }

  @Bean
  @Primary
  KafkaOperations<String, CarSaleEvent> kafkaOperations(KafkaProperties kafkaProperties) {
    ProducerFactory<String, CarSaleEvent> producerFactory = new DefaultKafkaProducerFactory<>(kafkaProperties.buildProducerProperties(new DefaultSslBundleRegistry()));
    return new KafkaTemplate<>(producerFactory);
  }

  record PostPublishedKafkaEvent(String carId, String title, String cost) {
    PostPublishedKafkaEvent {
      Objects.requireNonNull(carId, "Car Id must not be null!");
    }
  }*/

}
