package com.example.customerRM.service.implementation;

import com.example.customerRM.model.Customer;
import com.example.customerRM.repo.CustomerRepo;
import com.example.customerRM.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;
    @Override
    public Customer create(Customer customer) {
        log.info("saving new Customer: {}", customer.getName());
//        customer.setImageUrl(setCustomerImageUrl());
        return customerRepo.save(customer);
    }

    @Override
    public Collection<Customer> list(int limit) {
        log.info("Fetching all customers");
        return customerRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Customer get(Long id) {
        log.info("Fetching Customer by id: {}",id);
        return customerRepo.findById(id).get();
    }

    @Override
    public Customer update(Customer customer) {
        log.info("Updating Customer: {}", customer.getName());
        return customerRepo.save(customer);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting Customer: {}", id);
        customerRepo.deleteById(id);
        return TRUE;
    }

//    private String setCustomerImageUrl(){
//        return null;
//    }
}
