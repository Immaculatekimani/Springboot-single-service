package io.github.immaculate.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.immaculate.productservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    
}
