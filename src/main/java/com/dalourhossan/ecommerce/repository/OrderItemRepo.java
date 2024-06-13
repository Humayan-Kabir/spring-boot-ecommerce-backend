package com.dalourhossan.ecommerce.repository;

import com.dalourhossan.ecommerce.entity.OrderItem;
import com.dalourhossan.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
    @Query("SELECT p, SUM(oi.quantity * p.price) AS totalSales " +
            "FROM OrderItem oi " +
            "JOIN oi.product p " +
            "GROUP BY p " +
            "ORDER BY totalSales DESC" +
            " LIMIT :limit")
    List<Product> findTopSellingItems(int limit);
}
