package com.thamarai.mbook.repository;

import com.thamarai.mbook.entity.Copy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {

    @Query(value = "SELECT * FROM Copy c WHERE c.book_id = ?", nativeQuery = true)
    List<Copy> getAllCopiesByBookId(Long id);

}
