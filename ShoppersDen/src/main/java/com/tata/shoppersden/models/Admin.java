package com.tata.shoppersden.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private long adminId;
    private String adminName;
    private String adminPassword;

}
