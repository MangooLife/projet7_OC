package com.thamarai.mbook.controller;

import com.thamarai.mbook.entity.Book;
import com.thamarai.mbook.entity.Category;
import com.thamarai.mbook.entity.Copy;
import com.thamarai.mbook.exception.BookNotFoundException;
import com.thamarai.mbook.service.BookService;
import com.thamarai.mbook.service.CategoryService;
import com.thamarai.mbook.service.CopyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class BookController {

    private static final Logger LOGGER = LogManager.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private CopyService copyService;

    @Autowired
    private CategoryService categoryService;

    /**
     * Get all books
     * @return Set<Book>
     */
    @RequestMapping(value = {"/books"}, method = RequestMethod.GET)
    public  Set<Book> getBooks() {
        LOGGER.info("getBooks was called");
        Set<Book> books = (Set<Book>) bookService.getAllBooks();
        if(books == null) {
            LOGGER.error("There is any books in database...");
            throw new BookNotFoundException("There is any books in database...");
        }
        return books;
    }

    /**
     * Get book by id
     * @param id
     * @return Book
     */
    @RequestMapping(value = {"/book/{id}"}, method = RequestMethod.GET)
    public Book getBook(@PathVariable Long id) {
        LOGGER.info("getBook was called");
        Book book = null;
        try {
            book = bookService.getBook(id).orElseThrow (() -> new BookNotFoundException("There is any books in database with this id "+id));
        }
        catch(Exception e) {
            LOGGER.error("There is any book in database with this id "+id+" "+e);
        }
        return book;
    }

    /**
     * Get all copies of a book by his id
     * @param id
     * @return Set<Book>
     */
    @GetMapping(value = {"/copies/{id}"})
    public  Set<Copy> getCopiesById(@PathVariable Long id) {
        LOGGER.info("getCopiesById was called");
        Set<Copy> copies;
        try {
            copies = (Set<Copy>) copyService.getCopiesByBookId(id);
        } catch (Exception e) {
            LOGGER.error("There is no copies in database with this book id "+id+" "+e);
            throw new BookNotFoundException("There is no copies in database with this book id "+id);
        }

        return copies;
    }

    /**
     * Get all categories
     * @return List<Category>
     */
    @RequestMapping(value = {"/categories"}, method = RequestMethod.GET)
    public List<Category> getCategories() {
        LOGGER.info("getCategories was called");
        List<Category> categories;
        try {
            categories = categoryService.getAllCategories();
        } catch (Exception e) {
            LOGGER.error("There is no catagories in database..."+e);
            throw new BookNotFoundException("There is no catagories in database...");
        }
        return categories;
    }

    /**
     * Get books by category
     * @param categoryId
     * @return Set<Book>
     */
    @RequestMapping(value = {"/category"}, method = RequestMethod.POST)
    public Set<Book> getBooksByCategory(@RequestParam Long categoryId) {
        LOGGER.info("getBooksByCategory was called");
        Category category;
        try {
            category = categoryService.getCategory(categoryId).get();
        } catch (Exception e) {
            LOGGER.error("There is no category in database for this category id"+categoryId+" "+e);
            throw new BookNotFoundException("There is no category in database for this category id"+categoryId+" "+e);
        }
        Set<Book> books;
        try {
            books = category.getBooks();
        } catch (Exception e) {
            LOGGER.error("There is no books in database for this category id"+categoryId+" "+e);
            throw new BookNotFoundException("There is no books in database for this category id"+categoryId+" "+e);
        }
        return books;
    }

    /**
     * Get books by author
     * @param author
     * @return Set<Book>
     */
    @RequestMapping(value = {"/author"}, method = RequestMethod.POST)
    public Set<Book> getBooksByAuthor(@RequestParam String author) {
        LOGGER.info("getBooksByAuthor was called");
        Set<Book> books;
        try {
            books = bookService.getBooksByAuthor(author);
        } catch (Exception e) {
            LOGGER.error("There is no books in database with this author "+author+" "+e);
            throw new BookNotFoundException("There is no books in database with this author "+author+" "+e);
        }
        return books;
    }

    /**
     * Get books by keyword
     * @param keyword
     * @return Set<Book>
     */
    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
    public Set<Book> getBooksByKeyword(@RequestParam String keyword) {
        LOGGER.info("getBooksByKeyword was called");
        Set<Book> books;
        try {
            books = bookService.getBooksByKeyword(keyword);
        } catch (Exception e) {
            LOGGER.error("There is no books in database with this keyword "+keyword+" "+e);
            throw new BookNotFoundException("There is no books in database with this keyword "+keyword+" "+e);
        }
        return books;
    }
}
