package com.dalourhossan.ecommerce.service.imp;

import com.dalourhossan.ecommerce.entity.Product;
import com.dalourhossan.ecommerce.repository.OrderRepo;
import com.dalourhossan.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public List<Product> getTopSellingItemsByMonth(int limit, int lastMonth) {
        return orderRepo.findTopSellingItemsByMonth(limit, lastMonth);
    }
}
