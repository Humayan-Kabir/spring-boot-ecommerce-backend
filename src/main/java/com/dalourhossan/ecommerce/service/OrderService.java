package com.dalourhossan.ecommerce.service;

import com.dalourhossan.ecommerce.entity.Product;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
     List<Product> getTopSellingItemsByMonth(int limit, int lastMonth);
}
