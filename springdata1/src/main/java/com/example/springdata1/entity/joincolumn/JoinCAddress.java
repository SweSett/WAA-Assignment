package com.example.springdata1.entity.joincolumn;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="joincaddress")
public class JoinCAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String street;

    private String city;

    private String zip;

}
