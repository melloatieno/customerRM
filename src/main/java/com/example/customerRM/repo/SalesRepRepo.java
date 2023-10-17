package com.example.customerRM.repo;

import com.example.customerRM.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalesRepRepo extends JpaRepository<SalesRep, Long> {
    SalesRep findByPhoneNumber(String phoneNumber);

    Optional<SalesRep> findOneByPhoneNumberAndPassword(String phoneNumber, String password);
}
