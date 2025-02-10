package com.deivid.microservices;

import com.deivid.microservices.model.entity.ProductEntity;
import com.deivid.microservices.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@RequiredArgsConstructor
public class ProductServicesApplication implements CommandLineRunner {

    private final ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductServicesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll();

        productRepository.save(ProductEntity.builder()
                .productName("Curso microservicios")
                .productType("Cloud")
                .price(100L)
                .stock(100)
                .build());
    }
}
