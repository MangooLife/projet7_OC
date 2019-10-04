package com.thamarai.mperson.repository;

import com.thamarai.mperson.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Query(value = "SELECT * FROM Book b WHERE b.author = ?", nativeQuery = true)
    Set<Book> getAllBooksByAuthor(String author);

    @Query(value = "SELECT * FROM Book b WHERE b.title = ?", nativeQuery = true)
    Set<Book> getAllBookByBookKeyword(String keyword);
}
