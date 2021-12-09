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
                                 Arrays.asList(Float.valueOf(1.0F),
                                               Float.valueOf(2.0F),
                                               Float.valueOf(3.0F))));

        products.add(new Product(Long.valueOf(1),
                           "Campus FIUBA",
                                 Arrays.asList(Float.valueOf(1.0F),
                                               Float.valueOf(2.0F),
                                               Float.valueOf(3.0F))));

        return products;
    }
}
