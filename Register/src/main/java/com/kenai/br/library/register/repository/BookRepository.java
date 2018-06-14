package com.kenai.br.library.register.repository;

import com.kenai.br.library.register.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {

    Optional<Book> findByName(String name);
}
