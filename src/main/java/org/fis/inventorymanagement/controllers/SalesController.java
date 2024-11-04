package org.fis.inventorymanagement.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.fis.inventorymanagement.models.Sale;
import org.fis.inventorymanagement.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@Tag(name = "Sales", description = "Operations pertaining to sales")
public class SalesController {

    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @PostMapping
    public Sale createSale(@RequestBody Sale sale) {
        return salesService.createSale(sale);
    }

    @GetMapping
    public List<Sale> getAllSales() {
        return salesService.getAllSales();
    }

    @GetMapping("/{id}")
    public Sale getSaleById(@PathVariable int id) {
        return salesService.getSaleById(id);
    }

    @PutMapping("/{id}")
    public Sale updateSale(@PathVariable int id, @RequestBody Sale updatedSale) {
        return salesService.updateSale(id, updatedSale);
    }

    @DeleteMapping("/{id}")
    public void deleteSale(@PathVariable int id) {
        salesService.deleteSale(id);
    }
}
