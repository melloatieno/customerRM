package com.example.customerRM.service;

import com.example.customerRM.Dto.LoginDTO;
import com.example.customerRM.model.LoginResponse;
import com.example.customerRM.model.SalesRep;

import java.util.Collection;
import java.util.List;

public interface SalesRepService {
    SalesRep create(SalesRep salesRep);
    Collection<SalesRep> createMultiple(List<SalesRep> salesReps);
    Collection<SalesRep> list(int limit);
    SalesRep get(long id);
    SalesRep update(SalesRep salesRep);
    Boolean delete(long id);

    LoginResponse loginSalesRep(LoginDTO loginDTO);
}
