package com.thamarai.mbook.repository;

import com.thamarai.mbook.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findAllByOrderByIdAsc();
}
