package com.kabir.ecommerce.repository;

import com.kabir.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Product findByProductId(Long productId);
}
