package com.example.customerRM.repo;

import com.example.customerRM.model.Routes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepo extends JpaRepository<Routes, Long> {
    Routes findByRoute(String route);
}
