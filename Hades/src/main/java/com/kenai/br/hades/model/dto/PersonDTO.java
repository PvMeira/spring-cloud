package com.kenai.br.hades.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kenai.br.hades.model.domain.StatusType;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PersonDTO {

    private Long id;
    @NotBlank
    @Size(min = 1, max = 255)
    private String name;
    @NotBlank
    @Size(min = 1, max = 255)
    private String email;
    @NotNull
    private StatusType status;

    public static synchronized PersonDTO create() {
        return new PersonDTO();
    }

    public PersonDTO withId(Long id) {
        this.id = id;
        return this;
    }

    public PersonDTO withName(String name) {
        this.name = name;
        return this;
    }

    public PersonDTO withEmail(String email) {
        this.email = email;
        return this;
    }

    public PersonDTO withStatus(StatusType status) {
        this.status = status;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }
}
