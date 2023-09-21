package com.example.customerRM.model;

import com.example.customerRM.enumeration.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(255)")
    private String name;

    @Column(name = "contact_person", columnDefinition = "VARCHAR(255)")
    private String contactPerson;

    @Column(name = "phone_number", unique = true, columnDefinition = "VARCHAR(50)")
    @NotEmpty(message = "Phone number cannot be empty or null")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "VARCHAR(20)")
    private Gender gender;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Enumerated(EnumType.STRING)
    @Column(name = "chama", columnDefinition = "VARCHAR(20)")
    private Chama chama;

    @Enumerated(EnumType.STRING)
    @Column(name = "challenges", columnDefinition = "VARCHAR(20)")
    private Challenges challenges;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", columnDefinition = "VARCHAR(20)")
    private Category category;

    @Column(name = "supplier", columnDefinition = "VARCHAR(255)")
    private String supplier;

    @Column(name = "products", columnDefinition = "VARCHAR(255)")
    private String products;

    @Column(name = "weight")
    private int weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "freezer", columnDefinition = "VARCHAR(20)")
    private Freezer freezer;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "VARCHAR(20)")
    private CustomerStatus status;

}
