package com.example.springdata1.entity.unidirectional;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="uniaddress")
public class UniAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String street;

    private String city;

    private String zip;

}
