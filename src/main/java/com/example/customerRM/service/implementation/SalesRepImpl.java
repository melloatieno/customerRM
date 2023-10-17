package com.example.customerRM.service.implementation;

import com.example.customerRM.Dto.LoginDTO;
import com.example.customerRM.model.LoginResponse;
import com.example.customerRM.model.SalesRep;
import com.example.customerRM.repo.SalesRepRepo;
import com.example.customerRM.service.SalesRepService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class SalesRepImpl implements SalesRepService {
    private final SalesRepRepo salesRepRepo;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Override
    public SalesRep create(SalesRep salesRep) {
        String phoneNumber = salesRep.getPhoneNumber();
        String encodedPassword = this.passwordEncoder.encode(salesRep.getPassword());
        salesRep.setPassword(encodedPassword);
        SalesRep existingSalesRep = salesRepRepo.findByPhoneNumber(phoneNumber);
        if (existingSalesRep != null) {
            throw new IllegalArgumentException("Phone number must be unique");
        }
        log.info("Saving new Sales Rep: {}", salesRep.getName());
        return salesRepRepo.save(salesRep);
    }

    @Override
    public Collection<SalesRep> createMultiple(List<SalesRep> salesReps) {
        // Validate each SalesRep record before saving
        for (SalesRep salesRep : salesReps) {
            String phoneNumber = salesRep.getPhoneNumber();
            SalesRep existingSalesRep = salesRepRepo.findByPhoneNumber(phoneNumber);
            if (existingSalesRep != null) {
                throw new IllegalArgumentException("Phone number must be unique");
            }
        }

        log.info("Saving new Sales Reps: {}", salesReps);
        return salesRepRepo.saveAll(salesReps);
    }

    @Override
    public Collection<SalesRep> list(int limit) {
        log.info("Fetching all Sales Reps");
        return salesRepRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public SalesRep get(long id) {
        log.info("Fetching Sales Rep by id: {}", id);
        return salesRepRepo.findById(id).get();
    }

    @Override
    public SalesRep update(SalesRep salesRep) {
        log.info("Updating Sales Rep: {}", salesRep.getName());
        return salesRepRepo.save(salesRep);
    }

    @Override
    public Boolean delete(long id) {
        log.info("Deleting Sales Rep by ID: {}", id);
        salesRepRepo.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public LoginResponse loginSalesRep(LoginDTO loginDTO) {
        String phoneNumber = loginDTO.getPhoneNumber();
        String password = loginDTO.getPassword();

        SalesRep salesRep = salesRepRepo.findByPhoneNumber(phoneNumber);

        if (salesRep != null) {
            String encodedPassword = salesRep.getPassword();

            if (passwordEncoder.matches(password, encodedPassword)) {
                return new LoginResponse("Login Success", true);
            } else {
                return new LoginResponse("Login Failed - Incorrect Password", false);
            }
        } else {
            return new LoginResponse("Login Failed - Phone Number not Found", false);
        }
    }

}
