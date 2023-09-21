package com.example.customerRM.repo;

import com.example.customerRM.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepRepo extends JpaRepository<SalesRep, Long> {
    SalesRep findByPhoneNumber(String phoneNumber);
}
