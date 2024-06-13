package com.kabir.ecommerce.service.imp;

import com.kabir.ecommerce.entity.Product;
import com.kabir.ecommerce.repository.OrderRepo;
import com.kabir.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
