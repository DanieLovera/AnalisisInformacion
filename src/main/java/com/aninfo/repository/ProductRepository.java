package com.aninfo.repository;

import com.aninfo.model.product.Product;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ProductRepository {

    public Collection<Product> findAll() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(Long.valueOf(1),
                           "SIU Guarani",
                                 Arrays.asList("1.0.0",
                                               "1.0.1",
                                               "1.1.0",
                                               "1.1.1",
                                               "1.1.2",
                                               "2.0.0")));

        products.add(new Product(Long.valueOf(2),
                           "Campus FIUBA",
                                 Arrays.asList("1.0.0",
                                                "1.1.0",
                                                "1.2.0",
                                                "1.2.1")));

        return products;
    }
}
