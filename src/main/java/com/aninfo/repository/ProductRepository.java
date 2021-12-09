package com.aninfo.repository;

import com.aninfo.model.product.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ProductRepository {

    public Collection<Product> findAll() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> products = Arrays.asList(objectMapper.readValue
                (new File("C:\\Users\\USUARIO\\Desktop\\soporte\\src\\main\\resources\\products.json")
                        , Product[].class));
        return products;
    }
}
