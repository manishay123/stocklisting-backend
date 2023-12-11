package com.stackroute.WishlistService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.WishlistService.exception.StockAlreadyExistException;
import com.stackroute.WishlistService.exception.StockNotFoundInWishListException;
import com.stackroute.WishlistService.entity.WishList;
import com.stackroute.WishlistService.ResponseHandler.ResponseHandler;
import com.stackroute.WishlistService.service.FavService;
import com.stackroute.WishlistService.service.FavServiceImpl;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
 
@RestController
//@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("/wishlist")
public class FavController {
 
	@Autowired
	private FavServiceImpl favServiceImpl;
	
	@PostMapping("/add")
	public ResponseEntity<?> addTofavList(@RequestBody WishList newStock) throws StockAlreadyExistException{
		return ResponseEntity.status(HttpStatus.OK).body(this.favServiceImpl.addStockToFavList(newStock));
	}
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> removeFromFavList(@PathVariable Long userId) throws StockNotFoundInWishListException{
		return ResponseEntity.status(HttpStatus.OK).body(this.favServiceImpl.deleteStock(userId));
	}
	
	@GetMapping("/view/{userId}")
	public ResponseEntity<?> viewAllStock(@PathVariable Long userId) {
        List<WishList> favorites = favServiceImpl.getAllFavStockByUsername(userId);

        if (favorites.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No favorites found for user with ID: " + userId);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(favorites);
        }
    }
}