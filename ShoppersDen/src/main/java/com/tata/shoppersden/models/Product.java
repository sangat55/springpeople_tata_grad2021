package com.tata.shoppersden.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private long productId;
    private String productName;
    private String description;
    private double price;
    private int quantity;
    private String productImage;
    private Date dom;

}

