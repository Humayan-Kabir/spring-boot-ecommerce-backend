package com.kabir.ecommerce.service.imp;

import com.kabir.ecommerce.entity.Customer;
import com.kabir.ecommerce.entity.Product;
import com.kabir.ecommerce.entity.WishList;
import com.kabir.ecommerce.repository.CustomerRepo;
import com.kabir.ecommerce.repository.WishListRepo;
import com.kabir.ecommerce.service.WishListService;
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
