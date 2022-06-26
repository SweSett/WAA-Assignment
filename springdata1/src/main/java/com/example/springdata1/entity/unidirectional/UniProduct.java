package com.example.springdata1.entity.unidirectional;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="uniproduct")
public class UniProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private Double price;

    private Double rating;
}
