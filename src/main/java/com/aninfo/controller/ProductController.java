package com.aninfo.controller;

import com.aninfo.model.product.Product;
import com.aninfo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.Collection;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public Collection<Product> getAll() throws IOException {
        return productService.getProducts();
    }
}
