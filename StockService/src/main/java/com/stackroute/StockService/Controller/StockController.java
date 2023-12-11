package com.stackroute.StockService.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.StockService.Service.StockService;

@RestController
@RequestMapping("/api/v1.0/stocks")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/country/{countryName}")
    public ResponseEntity<?> getStocksByCountryName(@PathVariable String countryName) {
        try {
            return stockService.getStocksByCountryName(countryName);
        } catch (Exception e) {
        
            return new ResponseEntity<>("Error processing the request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


