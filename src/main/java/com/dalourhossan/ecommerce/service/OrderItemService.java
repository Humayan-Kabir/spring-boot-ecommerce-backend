package com.dalourhossan.ecommerce.service;

import com.dalourhossan.ecommerce.entity.Product;

import java.util.List;

public interface OrderItemService {
    List<Product> getTopSellingItems(int limit);
}
