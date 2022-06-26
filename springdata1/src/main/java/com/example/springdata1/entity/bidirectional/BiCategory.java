package com.example.springdata1.entity.bidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="bicategory")
public class BiCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    // @JoinColumn(name="category_id")
    @OneToMany(mappedBy = "bicategory")
    private List<BiProduct> biproducts;
}
