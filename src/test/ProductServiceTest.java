


public class ProductServiceTest {
     private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    void testCreateProduct() {
        Product productDTO = new Product(1,"Product1",100,10);
        Product product = prodcutService.createProduct(productDTO);
        assertNotNull(product);
        assertEquals(1, product.getProductId());
        assertEquals("Product1", product.getName());
        assertEquals(100, product.getPrice());
        assertEquals(10, product.getStock());
    }

    @Test
    void testGetAllProducts() {
        List<Product> product = productService.getAllProducts();
        assertNotNull(product);
        assertEquals(3, product.size());
    }

    @Test
    void testGetProductById() {
        Product product = productService.getProductById(1);
        assertNotNull(product);
        assertEquals(1, product.getId());
    }

    @Test
    void testUpdateSale() {
        Product product = productService.getProductById(1);

        product.setName("Product1(edit)");
        product.setPrice(150);
        product.setStock(15);

        Product updatedProduct = productService.updateProduct(1, product);

        assertNotNull(updatedProduct);
        assertEquals(1, updatedProduct.getProductId());
        assertEquals("Product1(edit)", updatedProduct.getName());
        assertEquals(150, updatedProduct.getPrice());
        assertEquals(15, updatedProduct.getStock());
    }

    @Test
    void testDeleteProduct() {
        prodcutService.deleteProduct(1);
        Product product = prodcutService.getProductById(1);
        assertNull(product);
    }
}