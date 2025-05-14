package org.example.model;

import java.util.HashSet;
import java.util.Set;

public class Author {
    private long id;
    private String name;

    private Set<Book> books = new HashSet<>();

    public Author() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
