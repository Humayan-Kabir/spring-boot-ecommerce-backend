package com.dalourhossan.ecommerce.service.imp;

import com.dalourhossan.ecommerce.entity.Product;
import com.dalourhossan.ecommerce.repository.OrderItemRepo;
import com.dalourhossan.ecommerce.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImp implements OrderItemService {
    @Autowired
    private OrderItemRepo orderItemRepo;

    @Override
    public List<Product> getTopSellingItems(int limit) {
        return orderItemRepo.findTopSellingItems(limit);
    }
}
