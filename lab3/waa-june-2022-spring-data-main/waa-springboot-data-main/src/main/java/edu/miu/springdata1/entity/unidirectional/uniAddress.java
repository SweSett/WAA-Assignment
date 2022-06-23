package edu.miu.springdata1.entity.unidirectional;

import lombok.Data;

import javax.persistence.GenerationType;
import javax.persistence.*;
@Entity
@Data
@Table(name="uniaddress")
public class uniAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;

    private String city;

    private String zip;

}
