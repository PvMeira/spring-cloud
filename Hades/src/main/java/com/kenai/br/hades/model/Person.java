package com.kenai.br.hades.model;

import com.kenai.br.hades.model.domain.StatusType;
import com.kenai.br.hades.model.domain.converter.StatusTypeConverter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "PERSON")
@SequenceGenerator(name = "PERSON_SEQ", sequenceName = "PERSON_SEQ", allocationSize = 1, initialValue = 5)
public class Person {

    @Id
    @GeneratedValue(generator = "PERSON_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Convert(converter = StatusTypeConverter.class)
    @Column(name = "STATUS")
    private StatusType status;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PERSON_PERMISSION"
            , joinColumns = @JoinColumn(name = "ID_PERSON")
            , inverseJoinColumns = @JoinColumn(name = "ID_PERMISSION"))
    private List<Permission> permissions;

    public static synchronized Person create() {
        return new Person();
    }

    public Person withId(Long id) {
        this.id = id;
        return this;
    }

    public Person withName(String name) {
        this.name = name;
        return this;
    }

    public Person withEmail(String email) {
        this.email = email;
        return this;
    }

    public Person withStatus(StatusType status) {
        this.status = status;
        return this;
    }

    public Person withPassword(String password) {
        this.password = password;
        return this;
    }

    public Person withPermissions(List<Permission> permissions) {
        this.permissions = permissions;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name) &&
                Objects.equals(email, person.email) &&
                status == person.status &&
                Objects.equals(password, person.password) &&
                Objects.equals(permissions, person.permissions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, email, status, password, permissions);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", password='" + password + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
