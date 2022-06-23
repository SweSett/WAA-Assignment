package edu.miu.springdata1.entity.joinedtable;

import edu.miu.springdata1.entity.bidirectional.biUser;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="addressJoin")
public class AddressJoined {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;

    private String city;

    private String zip;

    @OneToOne
    private UserJoined userJoined;
}
