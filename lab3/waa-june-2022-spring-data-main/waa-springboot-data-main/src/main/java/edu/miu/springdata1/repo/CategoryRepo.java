package edu.miu.springdata1.repo;

import edu.miu.springdata1.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category,Integer> {
}
