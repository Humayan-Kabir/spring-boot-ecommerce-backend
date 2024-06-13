package com.dalourhossan.ecommerce.service.imp;

import com.dalourhossan.ecommerce.repository.OrderRepo;
import com.dalourhossan.ecommerce.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SaleServiceImp implements SaleService {
    private final OrderRepo orderRepository;

    @Autowired
    public SaleServiceImp(OrderRepo orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Double getTotalSaleAmountOfCurrentDay() {
        LocalDate currentDate = LocalDate.now();
//        LocalDate specificDate = LocalDate.of(2024, 4, 30);
        return orderRepository.getTotalSaleAmountForCurrentDay(currentDate);
    }

    @Override
    public LocalDate getMaxSaleDay(LocalDate startDate, LocalDate endDate) {
        return orderRepository.findMaxSaleDateInRange(startDate, endDate);
    }
}
