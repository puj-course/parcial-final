package org.fis.inventorymanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Sale {
    private int id;
    private int productId;
    private int quantity;
    private double price;
    private String date;
}
