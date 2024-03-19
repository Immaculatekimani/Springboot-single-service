package io.github.immaculate.productservice.service;

import java.util.List;

import io.github.immaculate.productservice.model.ProductCreateRequest;
import io.github.immaculate.productservice.model.ProductCreateResponse;

public interface ProductService {

    ProductCreateResponse createProduct(ProductCreateRequest productCreateRequest);

    List<ProductCreateResponse> findAll();

    ProductCreateResponse findById(Integer productId);
    
}