package com.aninfo.service;

import com.aninfo.model.product.Product;
import com.aninfo.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProductService {

    private static final
    ProductRepository productRepository = new ProductRepository();

    public Collection<Product> getProducts() {
        return productRepository.findAll();
    }

    public ResponseEntity<Product> getProduct(Long productID) {
        Optional<Product> oproduct = productRepository.findById(productID);
        if (!oproduct.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.of(oproduct);
    }
}
