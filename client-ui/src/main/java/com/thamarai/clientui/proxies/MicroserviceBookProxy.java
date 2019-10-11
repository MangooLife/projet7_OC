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
import java.util.Set;

@FeignClient(name = "microservice-book", url = "localhost:9090")
public interface MicroserviceBookProxy {
    /**
     * Get all books
     * @return Set<Book>
     */
    @RequestMapping(value = {"/books"}, method = RequestMethod.GET)
    Set<Book> getBooks();

    /**
     * Get book by id
     * @param id
     * @return Book
     */
    @RequestMapping(value = {"/book/{id}"}, method = RequestMethod.GET)
    Book getBook( @PathVariable Long id);

    /**
     * Get all copies of a book by his id
     * @param id
     * @return Set<Copy>
     */
    @RequestMapping(value = {"/copies/{id}"}, method = RequestMethod.GET)
    Set<Copy> getCopiesById(@PathVariable Long id);

    /**
     * Get all categories
     * @return List<Category>
     */
    @RequestMapping(value = {"/categories"}, method = RequestMethod.GET)
    List<Category> getCategories();

    /**
     * Get books by category
     * @param categoryId
     * @return Set<Book>
     */
    @RequestMapping(value = {"/category"}, method = RequestMethod.POST)
    Set<Book> getBooksByCategory(@RequestParam Long categoryId);

    /**
     * Get books by author
     * @param author
     * @return Set<Book>
     */
    @RequestMapping(value = {"/author"}, method = RequestMethod.POST)
    Set<Book> getBooksByAuthor(@RequestParam String author);

    /**
     * Get books by keyword
     * @param keyword
     * @return Set<Book>
     */
    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
    Set<Book> getBooksByKeyword(@RequestParam String keyword);
}
