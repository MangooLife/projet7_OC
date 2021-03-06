package com.thamarai.mloanmanagement.repository;

import com.thamarai.mloanmanagement.entity.Copy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CopyRepository extends CrudRepository<Copy, Long> {

    @Query(value = "SELECT * FROM Copy c WHERE c.book_id = ?", nativeQuery = true)
    Set<Copy> getAllCopiesByBookId(Long id);

}
