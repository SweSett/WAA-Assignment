package com.example.springdata1.repo;

import com.example.springdata1.entity.Category;
import com.example.springdata1.entity.Product;
import com.example.springdata1.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
    public List<Product> findProductByPriceGreaterThan(Double price);

    @Query(value="SELECT * FROM Product p WHERE p.price > ?1",nativeQuery = true)
    public List<Product> findProduct(Double price);

    public List<Product> findAllByCategoryNameAndPriceLessThan(String c,double price);

    @Query(value="SELECT * FROM Product p left join category c on p.category_id=c.id where p.price<?2 and c.name=?1",nativeQuery = true)
    public List<Product> findProductByCat(String name,Double price);

    public List<Product> findAllByNameContainingIgnoreCase(String name);

    @Query(value="SELECT * FROM Product p WHERE upper(p.name) like upper(?1)",nativeQuery = true)
    public List<Product> findProductByPName(String name);

    public List<Product> findAllByUser(User user);

    @Query(value="SELECT * FROM Product p WHERE p.user_id=?1",nativeQuery = true)
    public List<Product> findByUserID(int id);
}
