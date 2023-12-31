package com.example.customerRM.repo;

import com.example.customerRM.enumeration.CustomerStatus;
import com.example.customerRM.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer findByPhoneNumber(String phoneNumber);
    int countByStatus(CustomerStatus status);
}
