package edu.miu.springdata1.entity.bidirectional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.miu.springdata1.entity.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="uniAddress")
public class biAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String street;

    private String city;

    private String zip;

    @OneToOne
    private biUser user;
}
