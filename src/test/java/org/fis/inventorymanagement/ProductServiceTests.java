package org.fis.inventorymanagement;

import org.fis.inventorymanagement.models.Product;
import org.fis.inventorymanagement.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTests {

    private ProductService productService;
    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    void createProductTest() {
        Product productDTO = new Product( 1,"Producto1", 10.65, 100);
        Product product = productService.createProduct(productDTO);
        assertNotNull(product);
        assertEquals(1, product.getId());
        assertEquals("Producto1", product.getName());
        assertEquals(10.65, product.getPrice());
        assertEquals(100, product.getStock());
    }
    @Test
    void getAllProductsTest() {
        List<Product> products = productService.getAllProducts();
        assertNotNull(products);
        assertEquals(3, products.size());
    }

    @Test
    void getProductByIdTest() {
        int id =1;
        Product product = productService.getProductById(id);
        assertNotNull(product);
        assertEquals(1, product.getId());
    }

    @Test
    void updateProductTest() {
        int id=1;
        Product product = productService.getProductById(id);

        product.setName("Producto actualizado");
        product.setPrice(23.54);
        product.setStock(15);

        Product updateProduct = productService.updateProduct(1, product);

        assertNotNull(updateProduct);
        assertEquals(1,updateProduct.getId());
        assertEquals("Producto actualizado",updateProduct.getName());
        assertEquals(23.54,updateProduct.getPrice());
        assertEquals(15,updateProduct.getStock());

    }

    @Test
    void deleteProductTest() {
        productService.deleteProduct(1);
        Product product = productService.getProductById(1);
        assertNull(product);
    }
}
