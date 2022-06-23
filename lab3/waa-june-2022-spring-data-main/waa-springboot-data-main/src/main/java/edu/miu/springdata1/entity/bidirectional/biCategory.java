package edu.miu.springdata1.entity.bidirectional;

import edu.miu.springdata1.entity.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="biCategory")
public class biCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    private List<Product> products;
}
