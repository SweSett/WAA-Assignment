package com.example.springdata1.entity.jointable;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="jointreview")
public class JoinTReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String comment;

    @ManyToOne
    private JoinTUser user;
}
