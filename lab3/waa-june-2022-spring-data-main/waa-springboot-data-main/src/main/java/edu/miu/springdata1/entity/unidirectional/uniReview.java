package edu.miu.springdata1.entity.unidirectional;
import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.springdata1.entity.Product;
import edu.miu.springdata1.entity.Review;
import edu.miu.springdata1.entity.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="review")
public class uniReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;
    private int numberOfStars;

}
