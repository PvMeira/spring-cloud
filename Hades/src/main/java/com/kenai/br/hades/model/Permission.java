package com.kenai.br.hades.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "PERMISSION")
public class Permission {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    public static synchronized Permission create() {
        return new Permission();
    }

    public Permission withId(Long id) {
        this.id = id;
        return this;
    }

    public Permission withDescription(String description) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
