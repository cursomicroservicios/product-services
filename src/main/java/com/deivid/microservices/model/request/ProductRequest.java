package com.deivid.microservices.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {
    private String productId;
    private String productName;
    private String productType;
    private Long price;
    private Integer stock;
}
