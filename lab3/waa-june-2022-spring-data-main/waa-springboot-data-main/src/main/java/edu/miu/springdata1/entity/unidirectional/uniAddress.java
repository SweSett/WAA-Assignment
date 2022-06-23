package edu.miu.springdata1.entity.unidirectional;

import javax.persistence.GenerationType;

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
