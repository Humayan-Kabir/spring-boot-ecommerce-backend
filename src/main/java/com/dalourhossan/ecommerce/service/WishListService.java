package com.dalourhossan.ecommerce.service;

import com.dalourhossan.ecommerce.entity.Product;
import java.util.List;

public interface WishListService {
    List<Product> getWishList(Long customerId);
}
