package com.example.customerRM.service;

import com.example.customerRM.model.Routes;

import java.util.Collection;

public interface RouteService{
    Routes create(Routes routes);
    Collection<Routes> list(int limit);
    Routes get(Long id);
    Routes update(Routes routes);
    Boolean delete(Long id);
}
