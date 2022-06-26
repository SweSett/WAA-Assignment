package com.example.springdata1.entity.joincolumn;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="joincusers")
public class JoinCUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @OneToMany
    @JoinColumn(name="user_id")
    private List<JoinCReview> reviews;

    @OneToOne
    @JoinColumn(name="address_id")
    private JoinCAddress address;
}
