package com.example.springdata1.entity.bidirectional;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="biproduct")
public class BiProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private Double price;

    private Double rating;

    @ManyToOne
    private BiCategory bicategory;
}
