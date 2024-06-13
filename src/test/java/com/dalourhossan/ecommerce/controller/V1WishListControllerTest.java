package com.dalourhossan.ecommerce.controller;

import com.dalourhossan.ecommerce.controller.api.v1.V1WishListController;
import com.dalourhossan.ecommerce.entity.Product;
import com.dalourhossan.ecommerce.service.WishListService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class V1WishListControllerTest {
    @InjectMocks
    private V1WishListController v1WishListController;

    @Mock
    private WishListService wishListService;

    @Test
    public void testGetCustomerWishList() {
        Long customerId = 1L;

        Product product1 = new Product();
        product1.setName("product1");
        product1.setDescription("product1 description");
        product1.setPrice(100);

        Product product2 = new Product();
        product2.setName("product2");
        product2.setDescription("product2 description");
        product2.setPrice(200);

        List<Product> expectedWishList = Arrays.asList(product1, product2);
        when(wishListService.getWishList(customerId)).thenReturn(expectedWishList);

        ResponseEntity<List<Product>> actualWishList = v1WishListController.getWishLists(customerId);

        Assertions.assertEquals(expectedWishList, Objects.requireNonNull(actualWishList.getBody()).stream().toList());
    }
}
