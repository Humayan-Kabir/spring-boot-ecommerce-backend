package com.kabir.ecommerce.service;

import java.time.LocalDate;

public interface SaleService {
    Double getTotalSaleAmountOfCurrentDay();
    LocalDate getMaxSaleDay(LocalDate startDate, LocalDate endDate);

}
