package edu.miu.springdata1.entity.joincolumn;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="reviewJoinCol")
public class reviewJoinedColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String comment;

}
