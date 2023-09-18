package com.example.task1.CustomerService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "customer")
public class CustomerEntity implements Serializable {
    @Id
    String id;
    String name;
    String city;
    String email;
}
