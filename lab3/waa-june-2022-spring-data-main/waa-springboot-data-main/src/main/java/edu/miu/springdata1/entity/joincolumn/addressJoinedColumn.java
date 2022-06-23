package edu.miu.springdata1.entity.joincolumn;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="addJoinCol")
public class addressJoinedColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;

    private String city;

    private String zip;
}
