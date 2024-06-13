package com.dalourhossan.ecommerce.service.imp;

import com.dalourhossan.ecommerce.entity.Customer;
import com.dalourhossan.ecommerce.entity.Product;
import com.dalourhossan.ecommerce.entity.WishList;
import com.dalourhossan.ecommerce.repository.CustomerRepo;
import com.dalourhossan.ecommerce.repository.WishListRepo;
import com.dalourhossan.ecommerce.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListServiceImp implements WishListService {
    @Autowired
    private WishListRepo wishListRepository;
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public List<Product> getWishList(Long customerId) {
        Customer customer = customerRepo.findByCustomerId(customerId);
        return wishListRepository.findByCustomer(customer).stream().map(
                WishList::getProduct
        ).toList();
    }
}
