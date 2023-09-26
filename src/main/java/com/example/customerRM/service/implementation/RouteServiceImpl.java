package com.example.customerRM.service.implementation;

import com.example.customerRM.model.Routes;
import com.example.customerRM.repo.RouteRepo;
import com.example.customerRM.service.RouteService;
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
public class RouteServiceImpl implements RouteService {
    private final RouteRepo routeRepo;

    @Override
    public Routes create(Routes routes) {
        log.info("Saving new route:{}", routes.getRoute());
        return routeRepo.save(routes);
    }

    @Override
    public Collection<Routes> list(int limit) {
        log.info("Fetching all routes");
        return routeRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Routes get(Long id) {
        log.info("Fetching Route by id: {}",id);
        return routeRepo.findById(id).get();
    }

    @Override
    public Routes update(Routes routes) {
        log.info("Updating Customer: {}", routes.getRoute());
        return routeRepo.save(routes);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting Customer: {}", id);
        routeRepo.deleteById(id);
        return TRUE;
    }
}
