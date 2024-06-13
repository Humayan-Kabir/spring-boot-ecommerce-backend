package com.kabir.ecommerce.service;

import com.kabir.ecommerce.entity.Product;

import java.util.List;

public interface OrderService {
     List<Product> getTopSellingItemsByMonth(int limit, int lastMonth);
}
