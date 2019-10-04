package com.thamarai.mbook.service;

import com.thamarai.mbook.entity.Book;
import com.thamarai.mbook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Set<Book> getAllBooks() {
        Set<Book> books = new HashSet<Book>();
        bookRepository.findAll()
                .forEach(books::add);
        return books;
    }

    public Set<Book> getBooksByAuthor(String author){
        Set<Book> books = new HashSet<Book>();
        bookRepository.getAllBooksByAuthor(author)
                .forEach(books::add);
        return books;
    }

    public Set<Book> getBooksByKeyword(String keyword){
        Set<Book> books = new HashSet<Book>();
        bookRepository.getAllBookByBookKeyword(keyword)
                .forEach(books::add);
        return books;
    }

    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Long id, Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
