package com.dalourhossan.ecommerce.repository;

import com.dalourhossan.ecommerce.entity.Order;
import com.dalourhossan.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order, Long> {
    @Query("SELECT COALESCE(SUM(oi.quantity * p.price), 0) " +
            "FROM Order o " +
            "JOIN o.orderItems oi " +
            "JOIN oi.product p " +
            "WHERE CAST(o.orderDate AS date) = :currentDate")
    double getTotalSaleAmountForCurrentDay(LocalDate currentDate);

    @Query("SELECT CAST(o.orderDate AS date) " +
            "FROM Order o " +
            "JOIN o.orderItems oi " +
            "JOIN oi.product p " +
            "WHERE CAST(o.orderDate AS date) BETWEEN :startDate AND :endDate " +
            "GROUP BY CAST(o.orderDate AS date) " +
            "ORDER BY SUM(oi.quantity * p.price) DESC LIMIT 1")
    LocalDate findMaxSaleDateInRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT p, SUM(oi.quantity * p.price) AS totalSales " +
            "FROM Order o " +
            "JOIN o.orderItems oi " +
            "JOIN oi.product p " +
            "WHERE MONTH(o.orderDate) = :month " +
            "GROUP BY p " +
            "ORDER BY totalSales DESC " +
            " LIMIT :limit")
    List<Product> findTopSellingItemsByMonth(int limit, int month);
}
