package com.kenai.br.hades.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PermissionDTO {

    private Long id;
    @Size(min = 1, max = 255)
    @NotBlank
    private String description;

    public static synchronized PermissionDTO create() {
        return new PermissionDTO();
    }

    public PermissionDTO withId(Long id) {
        this.id = id;
        return this;
    }

    public PermissionDTO withDescription(String description) {
        this.description = description;
        return this;
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
}
