package edu.miu.springdata1.entity.unidirectional;

import edu.miu.springdata1.entity.Address;
import edu.miu.springdata1.entity.Review;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="user")
public class uniUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @OneToMany
    private List<Review> reviews;

    @OneToOne
    private Address address;
}
