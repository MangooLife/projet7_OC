package com.thamarai.clientui.proxies;

import com.thamarai.clientui.entity.Book;
import com.thamarai.clientui.entity.Category;
import com.thamarai.clientui.entity.Copy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(contextId = "microserviceBookProxy", name = "zuul-server")
public interface MicroserviceBookProxy {
    /**
     * Get all books
     * @return Set<Book>
     */
    @RequestMapping(value = {"/microservice-book/books"}, method = RequestMethod.GET)
    List<Book> getBooks();

    /**
     * Get book by id
     * @param id
     * @return Book
     */
    @RequestMapping(value = {"/microservice-book/book/{id}"}, method = RequestMethod.GET)
    Book getBook( @PathVariable Long id);

    /**
     * Get all copies of a book by his id
     * @param id
     * @return Set<Copy>
     */
    @RequestMapping(value = {"/microservice-book/copies/{id}"}, method = RequestMethod.GET)
    List<Copy> getCopiesById(@PathVariable Long id);

    /**
     * Get all categories
     * @return List<Category>
     */
    @RequestMapping(value = {"/microservice-book/categories"}, method = RequestMethod.GET)
    List<Category> getCategories();

    /**
     * Get books by category
     * @param categoryId
     * @return List<Book>
     */
    @RequestMapping(value = {"/microservice-book/category/{categoryId}"}, method = RequestMethod.GET)
    List<Book> getBooksByCategoryId(@PathVariable Long categoryId);

    /**
     * Get books by category
     * @param categoryId
     * @return Set<Book>
     */
    @RequestMapping(value = {"/microservice-book/category"}, method = RequestMethod.POST)
    List<Book> getBooksByCategory(@RequestParam Long categoryId);

    /**
     * Get books by author
     * @param author
     * @return Set<Book>
     */
    @RequestMapping(value = {"/microservice-book/author"}, method = RequestMethod.POST)
    List<Book> getBooksByAuthor(@RequestParam String author);

    /**
     * Get books by keyword
     * @param keyword
     * @return Set<Book>
     */
    @RequestMapping(value = {"/microservice-book/search"}, method = RequestMethod.POST)
    List<Book> getBooksByKeyword(@RequestParam String keyword);
}
