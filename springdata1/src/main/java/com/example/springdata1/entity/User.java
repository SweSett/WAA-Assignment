package com.example.springdata1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;


    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Review> reviews;

    @OneToOne(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Address address;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Product> products;
}
