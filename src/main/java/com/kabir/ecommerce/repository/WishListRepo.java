package com.kabir.ecommerce.repository;

import com.kabir.ecommerce.entity.Customer;
import com.kabir.ecommerce.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface WishListRepo extends JpaRepository<WishList, Long> {
    List<WishList> findByCustomer(Customer customer);
    WishList findByWishListId(Long wishListId);
}
