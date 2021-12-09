package com.aninfo.service;

import com.aninfo.model.product.Product;
import com.aninfo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;

@Service
public class ProductService {

    private static final
    ProductRepository productRepository = new ProductRepository();

    public Collection<Product> getProducts() {
        return productRepository.findAll();
    }
}
