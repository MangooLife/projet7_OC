package com.thamarai.mbook.repository;

import com.thamarai.mbook.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Query(value = "SELECT * FROM Book b WHERE author LIKE '%in%'", nativeQuery = true)
    List<Book> findByAuthorLike(String author);

    @Query(value = "SELECT * FROM Book b WHERE title  OR AUTHOR OR DESCRIPTION LIKE '%in%'", nativeQuery = true)
    List<Book> findByKeywordLike(String keyword);
}
