package com.thamarai.batch.entity;

import java.util.HashSet;
import java.util.Set;

public class Book {

    private Long id;

    private String description;

    private String author;

    private String image;

    private Set<Copy> copies = new HashSet<Copy>();

    private Set<Category> bookCategories  = new HashSet<Category>();

    public Book() {
    }

    public Book(String description, String author, String image, Set<Copy> copies, Set<Category> bookCategories) {
        this.description = description;
        this.author = author;
        this.image = image;
        this.copies = copies;
        this.bookCategories = bookCategories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Copy> getCopies() {
        return copies;
    }

    public void setCopies(Set<Copy> copies) {
        this.copies = copies;
    }

    public Set<Category> getBookCategories() {
        return bookCategories;
    }

    public void setBookCategories(Set<Category> bookCategories) {
        this.bookCategories = bookCategories;
    }
}