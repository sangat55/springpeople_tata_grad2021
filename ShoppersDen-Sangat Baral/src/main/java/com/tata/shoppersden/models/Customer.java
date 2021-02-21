package com.tata.shoppersden.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private long customerId;
    private String customerName;
    private String address;
    private String emailId;
    private String password;
    private long phone;
    private String securityQuestion;
    private String securityAnswer;
}
