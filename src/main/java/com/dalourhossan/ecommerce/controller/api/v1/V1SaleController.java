package com.dalourhossan.ecommerce.controller.api.v1;

import com.dalourhossan.ecommerce.entity.Product;
import com.dalourhossan.ecommerce.service.OrderItemService;
import com.dalourhossan.ecommerce.service.OrderService;
import com.dalourhossan.ecommerce.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
public class V1SaleController {
    private final SaleService saleService;
    private final OrderItemService orderItemService;
    private final OrderService orderService;


    @Autowired
    public V1SaleController(SaleService saleService,
                            OrderItemService orderItemService,
                            OrderService orderService) {
        this.saleService = saleService;
        this.orderItemService = orderItemService;
        this.orderService = orderService;
    }

    @GetMapping("/total-amount")
    public ResponseEntity<Double> getTotalSaleAmountOfCurrentDay() {
        double totalSaleAmount = saleService.getTotalSaleAmountOfCurrentDay();
        return ResponseEntity.status(HttpStatus.OK).body(totalSaleAmount);
    }

    @GetMapping("/max-sale-day")
    public ResponseEntity<LocalDate> getMaxSaleDay(@RequestParam("startDate") String startDateStr,
                                                   @RequestParam("endDate") String endDateStr) {
        startDateStr = startDateStr.trim();
        endDateStr = endDateStr.trim();
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);
        LocalDate maxSaleDay = saleService.getMaxSaleDay(startDate, endDate);
        return ResponseEntity.status(HttpStatus.OK).body(maxSaleDay);
    }

    @GetMapping("top-selling-products/{limit}")
    public ResponseEntity<List<Product>> getTopSellingItems(@PathVariable int limit) {
        return ResponseEntity.status(HttpStatus.OK).body(
                orderItemService.getTopSellingItems(limit)
        );
    }

    @GetMapping("/top-selling-products/last-month/{limit}")
    public ResponseEntity<List<Product>> getTopSellingItemsByMonth(@PathVariable int limit, int i) {
        LocalDate lastMonth = LocalDate.now().minusMonths(1);
        int monthValue = lastMonth.getMonthValue();
        return ResponseEntity.status(HttpStatus.OK).body(
                orderService.getTopSellingItemsByMonth(limit, monthValue)
        );
    }
}
