package com.example.customerRM.resource;

import com.example.customerRM.enumeration.CustomerStatus;
import com.example.customerRM.model.Customer;
import com.example.customerRM.model.Response;
import com.example.customerRM.service.implementation.CustomerServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerServiceImpl customerService;

    @GetMapping("/list")
    public ResponseEntity<Response> getCustomers(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("customers", customerService.list(30)))
                        .message("Customers Retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveCustomer(@RequestBody @Valid Customer customer){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("customers", customerService.create(customer)))
                        .message("Customer Created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getCustomer(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("customers", customerService.get(id) ))
                        .message("Customer Retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteCustomer(@PathVariable("id") Long id){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", customerService.delete(id) ))
                        .message("Customer Deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );

    }

    @GetMapping("/count")
    public ResponseEntity<Map<String, Integer>> countByStatus(@RequestParam CustomerStatus status){
        Map<String, Integer> result = new HashMap<>();
        int customerCount = customerService.countByStatus(status);
        result.put("count", customerCount);
        return ResponseEntity.ok().body(result);
    }
}
