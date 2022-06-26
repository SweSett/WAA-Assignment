package com.example.springdata1.entity.jointable;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="jointusers")
public class JoinTUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @OneToMany
    @JoinTable
    private List<JoinTReview> reviews;

    @OneToOne
    @JoinTable(name="joint_user_address")
    private JoinTAddress address;
}
