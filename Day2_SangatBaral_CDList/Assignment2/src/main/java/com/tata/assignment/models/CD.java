package com.tata.assignment.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CD {
    private long singerId;
    private String title;
    private String singer;
}
