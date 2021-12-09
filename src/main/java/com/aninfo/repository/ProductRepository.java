package com.aninfo.repository;

import com.aninfo.model.product.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ProductRepository {

    public Collection<Product> findAll() throws IOException {
        /*ObjectMapper objectMapper = new ObjectMapper();
        List<Product> products = Arrays.asList(objectMapper.readValue
                (new File("C:\\Users\\USUARIO\\Desktop\\soporte\\src\\main\\resources\\products.json")
                        , Product[].class));*/
        List<Product> products = new ArrayList<>();
        products.add(new Product(Long.valueOf(1), "SIU Guarani", Float.valueOf(1.0F)));
        products.add(new Product(Long.valueOf(1), "SIU Guarani", Float.valueOf(2.0F)));
        products.add(new Product(Long.valueOf(1), "SIU Guarani", Float.valueOf(3.0F)));
        products.add(new Product(Long.valueOf(1), "Campus FIUBA", Float.valueOf(1.0F)));
        products.add(new Product(Long.valueOf(1), "Campus FIUBA", Float.valueOf(2.0F)));
        products.add(new Product(Long.valueOf(1), "Campus FIUBA", Float.valueOf(3.0F)));
        return products;
    }
}
