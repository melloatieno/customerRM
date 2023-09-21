package com.example.customerRM.service;

import com.example.customerRM.enumeration.CustomerStatus;
import com.example.customerRM.model.Customer;
import com.example.customerRM.model.SalesRep;

import java.util.Collection;
import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);
    Collection<Customer> createMultiple(List<Customer> customers);
    Collection<Customer> list(int limit);
    Customer get(Long id);
    Customer update(Customer customer);
    Boolean delete(Long id);
    int countByStatus(CustomerStatus status);
}
