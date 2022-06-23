package edu.miu.springdata1.entity.joinedtable;

import edu.miu.springdata1.entity.bidirectional.biUser;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="reviewJoin")
public class ReviewJoined {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String comment;

    @ManyToOne
    private UserJoined userJoined;
}
