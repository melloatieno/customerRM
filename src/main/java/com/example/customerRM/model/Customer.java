package com.example.customerRM.model;

import com.example.customerRM.enumeration.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String contactPerson;
    @Column(unique = true)
    @NotEmpty(message = "Phone number cannot be empty or null")
    private int phoneNumber;
    private Gender gender;
    private String location;
    private Chama chama;
    private Challenges challenges;
    private Category category;
    private String supplier;
    private String products;
    private int weight;
    private Freezer freezer;
}
