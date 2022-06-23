package edu.miu.springdata1.entity.bidirectional;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="bireview")
public class biReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String comment;

   @ManyToOne
    private biUser biUser;
}
