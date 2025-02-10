package com.deivid.microservices.service.impl;

import com.deivid.microservices.model.response.ProductResponse;
import com.deivid.microservices.repository.ProductRepository;
import com.deivid.microservices.service.ProductService;
import com.deivid.microservices.util.UtilMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Value("${server.port}")
    private Integer port;

    private final ProductRepository productRepository;

    @Override
    public List<ProductResponse> getAllProducts() {
        return UtilMapper.convertEntitiesToResponses(productRepository.findAll())
                .stream()
                .map(product -> product.toBuilder().port(port).build())
                .toList();
    }
}
