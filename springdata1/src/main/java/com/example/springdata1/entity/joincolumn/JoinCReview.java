package com.example.springdata1.entity.joincolumn;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="joincreview")
public class JoinCReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String comment;

}
