package com.deivid.microservices.service;


import com.deivid.microservices.model.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductResponse> getAllProducts();
}
