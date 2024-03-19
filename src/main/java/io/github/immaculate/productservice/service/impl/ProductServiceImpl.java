package io.github.immaculate.productservice.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import io.github.immaculate.productservice.entity.Product;
import io.github.immaculate.productservice.exception.ProductNotFoundException;
import io.github.immaculate.productservice.model.ProductCreateRequest;
import io.github.immaculate.productservice.model.ProductCreateResponse;
import io.github.immaculate.productservice.repository.ProductRepository;
import io.github.immaculate.productservice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this. productRepository = productRepository;
    }

    @Override
    public ProductCreateResponse createProduct(ProductCreateRequest productCreateRequest) {
       var savedProduct =  productRepository.save(mapToProductEntity(productCreateRequest));
       return mapToProductCreateResponse(savedProduct);
    }

    private Product mapToProductEntity(ProductCreateRequest source){
        Product target = new Product();
        BeanUtils.copyProperties(source, target);
        return target;

    }
    private ProductCreateResponse mapToProductCreateResponse(Product source){
        ProductCreateResponse target = new ProductCreateResponse();
        BeanUtils.copyProperties(source, target);
        return target;

    }

    @Override
    public List<ProductCreateResponse> findAll() {
       return productRepository.findAll().stream().map(this::mapToProductCreateResponse).toList();
      }

    @Override
    public ProductCreateResponse findById(Integer productId) {
        var pr =  productRepository.findById(productId);
       if(pr.isPresent()){
        return mapToProductCreateResponse(pr.get());
       }
        throw new ProductNotFoundException("Product with id not found");
    }
    
}