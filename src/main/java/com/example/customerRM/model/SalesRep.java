package com.example.customerRM.model;

import com.example.customerRM.enumeration.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesRep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "phone_number", unique = true)
    @NotEmpty(message = "Phone number cannot be empty or null")
    private String phoneNumber;

    @Column(name = "password", unique = true)
    @NotEmpty(message = "Password must be unique")
    private String password;
}
