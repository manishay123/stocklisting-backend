package com.stackroute.StockService.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Stock {

    private ArrayList<com.stackroute.StockService.Entity.Data> data = new ArrayList<>();

}
