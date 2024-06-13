package com.kabir.ecommerce.service.imp;

import com.kabir.ecommerce.entity.Product;
import com.kabir.ecommerce.repository.OrderItemRepo;
import com.kabir.ecommerce.service.OrderItemService;
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
