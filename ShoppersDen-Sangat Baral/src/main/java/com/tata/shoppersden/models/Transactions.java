package com.tata.shoppersden.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {
    private long transactionId;
    private long customerId;
    private long productId;
    private Date transactionDate;

}
