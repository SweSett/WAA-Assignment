package com.example.springdata1.entity.bidirectional;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="bireview")
public class BiReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String comment;

    @ManyToOne
    private BiUser user;
}
