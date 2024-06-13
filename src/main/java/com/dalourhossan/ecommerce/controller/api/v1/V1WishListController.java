package com.dalourhossan.ecommerce.controller.api.v1;

import com.dalourhossan.ecommerce.entity.Product;
import com.dalourhossan.ecommerce.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wishlist")
public class V1WishListController {
    @Autowired
    private WishListService wishListService;
    @GetMapping("/{customerId}")
    public ResponseEntity<List<Product>> getWishLists(@PathVariable Long customerId) {
        List<Product> wishList = wishListService.getWishList(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(wishList);
    }
}
