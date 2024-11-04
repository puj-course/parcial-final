package org.fis.inventorymanagement.services;

import org.fis.inventorymanagement.models.Sale;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalesService {

    private final List<Sale> sales = new ArrayList<>(
            List.of(
                    new Sale(1, 1, 10, 100, "2021-05-01"),
                    new Sale(2, 2, 5, 50, "2021-05-02"),
                    new Sale(3, 3, 20, 200, "2021-05-03")
            )
    );

    public Sale createSale(Sale sale) {
        sales.add(sale);
        return sale;
    }

    public List<Sale> getAllSales() {
        return sales;
    }

    public Sale getSaleById(int id) {
        return sales.stream()
                .filter(sale -> sale.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Sale updateSale(int id, Sale updatedSale) {
        for (Sale sale : sales) {
            if (sale.getId() == id) {
                sale.setProductId(updatedSale.getProductId());
                sale.setQuantity(updatedSale.getQuantity());
                sale.setPrice(updatedSale.getPrice());
                sale.setDate(updatedSale.getDate());
                return sale;
            }
        }
        return null;
    }

    public void deleteSale(int id) {
        sales.removeIf(sale -> sale.getId() == id);
    }
}
