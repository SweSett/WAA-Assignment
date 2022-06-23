package edu.miu.springdata1.entity.joincolumn;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="userJoinCol")
public class userJoinedColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @OneToMany
    @JoinColumn(name = "review_id")
    private List<reviewJoinedColumn> reviews;

    @OneToOne
    @JoinColumn(name="address_id")
    private addressJoinedColumn address;
}
