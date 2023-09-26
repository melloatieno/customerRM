package com.example.customerRM.resource;

import com.example.customerRM.model.Response;
import com.example.customerRM.model.Routes;
import com.example.customerRM.service.implementation.RouteServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static java.util.Map.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/routes")
@RequiredArgsConstructor
public class RoutesController {
    private final RouteServiceImpl routeService;

    @GetMapping("/list")
    public ResponseEntity<Response> getRoutes(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("routes", routeService.list(30)))
                        .message("Routes Retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @GetMapping("/save")
    public ResponseEntity<Response> saveRoutes(@RequestBody @Valid Routes routes){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("routes", routeService.create(routes)))
                        .message("Route Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getRoutes(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("routes", routeService.get(id) ))
                        .message("Route Retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteRoutes(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", routeService.delete(id) ))
                        .message("Route Deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
