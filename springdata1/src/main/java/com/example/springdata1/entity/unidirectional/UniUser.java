package com.example.springdata1.entity.unidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="uniusers")
public class UniUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @OneToMany
    private List<UniReview> reviews;

    @OneToOne
    private UniAddress address;
}
