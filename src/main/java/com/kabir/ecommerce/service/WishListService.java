package com.kabir.ecommerce.service;

import com.kabir.ecommerce.entity.Product;
import java.util.List;

public interface WishListService {
    List<Product> getWishList(Long customerId);
}
