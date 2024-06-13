package com.dalourhossan.ecommerce.service;

import java.time.LocalDate;

public interface SaleService {
    Double getTotalSaleAmountOfCurrentDay();
    LocalDate getMaxSaleDay(LocalDate startDate, LocalDate endDate);

}
