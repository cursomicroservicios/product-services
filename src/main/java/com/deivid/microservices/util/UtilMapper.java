package com.deivid.microservices.util;

import com.deivid.microservices.model.entity.ProductEntity;
import com.deivid.microservices.model.request.ProductRequest;
import com.deivid.microservices.model.response.ProductResponse;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class UtilMapper {

    public static List<ProductResponse> convertEntitiesToResponses(Iterable<ProductEntity> products) {
        return StreamSupport.stream(products.spliterator(), false)
                .map(UtilMapper::convertEntityToResponse)
                .collect(Collectors.toList());
    }

    public static ProductResponse convertEntityToResponse(Optional<ProductEntity> optionalProductEntity) {
        return optionalProductEntity
                .map(UtilMapper::convertEntityToResponse)
                .orElse(null);
    }

    public static ProductResponse convertEntityToResponse(ProductEntity productEntity) {
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(productEntity, productResponse);
        return productResponse;
    }

    public static ProductEntity convertRequestToEntity(ProductRequest productRequest) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productRequest, productEntity);
        return productEntity;
    }
}
