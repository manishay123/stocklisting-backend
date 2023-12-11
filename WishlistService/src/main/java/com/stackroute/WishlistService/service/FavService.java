package com.stackroute.WishlistService.service;

import java.util.List;



import com.stackroute.WishlistService.entity.WishList;

import com.stackroute.WishlistService.exception.StockAlreadyExistException;
import com.stackroute.WishlistService.exception.StockNotFoundInWishListException;


public interface FavService {
 
    List<WishList> getAllFavStockByUsername(Long userId);
 
    WishList addStockToFavList(WishList newStock) throws StockAlreadyExistException;
    
    String deleteStock(long favId) throws StockNotFoundInWishListException;
 }