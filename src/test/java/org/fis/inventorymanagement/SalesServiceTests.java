package org.fis.inventorymanagement;

import org.fis.inventorymanagement.models.Sale;
import org.fis.inventorymanagement.services.SalesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SalesServiceTests {

    private SalesService salesService;

    @BeforeEach
    void setUp() {
        salesService = new SalesService();
    }

    @Test
    void testCreateSale() {
        Sale saleDTO = new Sale( 4,4, 10, 100.0, "2021-05-04");
        Sale sale = salesService.createSale(saleDTO);
        assertNotNull(sale);
        assertEquals(4, sale.getProductId());
        assertEquals(10, sale.getQuantity());
        assertEquals(100.0, sale.getPrice());
        assertEquals("2021-05-04", sale.getDate());
    }

    @Test
    void testGetAllSales() {
        List<Sale> sales = salesService.getAllSales();
        assertNotNull(sales);
        assertEquals(3, sales.size());
    }

    @Test
    void testGetSaleById() {
        Sale sale = salesService.getSaleById(1);
        assertNotNull(sale);
        assertEquals(1, sale.getId());
    }

    @Test
    void testUpdateSale() {
        Sale sale = salesService.getSaleById(1);

        sale.setQuantity(15);
        sale.setPrice(150.0);
        sale.setDate("2021-05-05");

        Sale updatedSale = salesService.updateSale(1, sale);

        assertNotNull(updatedSale);
        assertEquals(1, updatedSale.getProductId());
        assertEquals(15, updatedSale.getQuantity());
        assertEquals(150.0, updatedSale.getPrice());
        assertEquals("2021-05-05", updatedSale.getDate());
    }

    @Test
    void testDeleteSale() {
        salesService.deleteSale(1);
        Sale sale = salesService.getSaleById(1);
        assertNull(sale);
    }
}
