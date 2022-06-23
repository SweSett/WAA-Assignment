package edu.miu.springdata1.entity.bidirectional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.miu.springdata1.entity.Category;
import edu.miu.springdata1.entity.Review;
import edu.miu.springdata1.entity.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="biProduct")
public class biProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private float price;
    private int rating;

    @ManyToOne
    private biCategory bicategory;
}
