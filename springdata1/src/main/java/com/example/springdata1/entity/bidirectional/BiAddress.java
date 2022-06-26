package com.example.springdata1.entity.bidirectional;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="biaddress")
public class BiAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String street;

    private String city;

    private String zip;

    @OneToOne
    private BiUser user;
}
