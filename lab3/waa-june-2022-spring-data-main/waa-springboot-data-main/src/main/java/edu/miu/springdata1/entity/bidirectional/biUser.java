package edu.miu.springdata1.entity.bidirectional;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="biusers")
public class biUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @OneToMany(mappedBy = "biUser")
    private List<biReview> reviews;

    @OneToOne(mappedBy = "user")
    private biAddress address;
}
