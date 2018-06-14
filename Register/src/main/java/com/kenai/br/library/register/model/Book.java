package com.kenai.br.library.register.model;

import javax.persistence.*;

@Entity(name = "BOOK")
@SequenceGenerator(name = "BOOK_SEQ", sequenceName = "BOOK_SEQ", allocationSize = 1)
public class Book {

    @Id
    @GeneratedValue(generator = "BOOK_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    public static synchronized Book create() {
        return new Book();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book withId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book withName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book withDescription(String description) {
        this.description = description;
        return this;
    }
}
