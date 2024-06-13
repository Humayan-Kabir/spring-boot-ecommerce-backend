package com.dalourhossan.ecommerce.controller;

import com.dalourhossan.ecommerce.controller.api.v1.V1SaleController;
import com.dalourhossan.ecommerce.entity.Product;
import com.dalourhossan.ecommerce.service.OrderItemService;
import com.dalourhossan.ecommerce.service.OrderService;
import com.dalourhossan.ecommerce.service.SaleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class V1SaleControllerTest {
    @InjectMocks
    private V1SaleController v1SaleController;
    @Mock
    private SaleService saleService;
    @Mock
    private OrderItemService orderItemService;
    @Mock
    private OrderService orderService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetTotalSaleAmountOfCurrentDay() {
        LocalDate today = LocalDate.now();
        double expectedTotalSale = 1234.56;
        when(saleService.getTotalSaleAmountOfCurrentDay()).thenReturn(expectedTotalSale);

        ResponseEntity<Double> actualTotalSale = v1SaleController.getTotalSaleAmountOfCurrentDay();

        assertEquals(expectedTotalSale, Objects.requireNonNull(actualTotalSale.getBody()), 0.001);
    }

    @Test
    public void testGetMaxSaleDayByRange() {
        LocalDate startDate = LocalDate.of(2024, 5, 1);
        LocalDate endDate = LocalDate.of(2024, 5, 10);
        LocalDate expectedMaxSaleDay = LocalDate.of(2024, 5, 5);
        when(saleService.getMaxSaleDay(startDate, endDate)).thenReturn(expectedMaxSaleDay);

        ResponseEntity<LocalDate> actualMaxSaleDay = v1SaleController.getMaxSaleDay(startDate.toString(), endDate.toString());

        assertEquals(expectedMaxSaleDay, actualMaxSaleDay.getBody());
    }

    @Test
    public void testGetTopSellingItems() {
        Product product1 = new Product();
        product1.setName("product1");
        product1.setDescription("product1 description");
        product1.setPrice(100);

        Product product2 = new Product();
        product2.setName("product2");
        product2.setDescription("product2 description");
        product2.setPrice(200);

        List<Product> expectedTopItems = Arrays.asList(product1, product2);
        when(orderItemService.getTopSellingItems(2)).thenReturn(expectedTopItems);
        ResponseEntity<List<Product>> actualTopItems = v1SaleController.getTopSellingItems(2);

        assertEquals(expectedTopItems, Objects.requireNonNull(actualTopItems.getBody()).stream().toList());
    }

    @Test
    public void testGetTopSellingItemsByMonth() {
        LocalDate lastMonth = LocalDate.now().minusMonths(1);
        Product product1 = new Product();
        product1.setName("product1");
        product1.setDescription("product1 description");
        product1.setPrice(100);

        Product product2 = new Product();
        product2.setName("product2");
        product2.setDescription("product2 description");
        product2.setPrice(200);

        List<Product> expectedTopProducts = Arrays.asList(product1, product2);
        when(orderService.getTopSellingItemsByMonth(2,4)).thenReturn(expectedTopProducts);

        ResponseEntity<List<Product>> actualTopProducts = v1SaleController.getTopSellingItemsByMonth(2, 4);

        assertEquals(expectedTopProducts, Objects.requireNonNull(actualTopProducts.getBody()).stream().toList());
    }
}
