package com.example.springdata1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    // @JoinColumn(name="category_id")
    @JsonIgnoreProperties("category")
    @OneToMany(mappedBy = "category",cascade = CascadeType.PERSIST)
    private List<Product> products;
}
