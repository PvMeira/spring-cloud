package com.kenai.br.library.register.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class BookDTO {

    private Long id;
    @NotBlank
    @Size(min = 1, max = 255)
    private String name;
    @NotBlank
    @Size(min = 1, max = 255)
    private String description;

    public static synchronized BookDTO create() {
        return new BookDTO();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookDTO withId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookDTO withName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BookDTO withDescription(String description) {
        this.description = description;
        return this;
    }
    
}
