package org.fis.inventorymanagement.services;

import org.fis.inventorymanagement.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>(
            List.of(
                    new Product(1, "Product1", 100, 10),
                    new Product(2, "Product2", 50, 5),
                    new Product(3, "Product3", 200, 20)
            )
    );

    // TODO: Implement the methods for the ProductService class
}
