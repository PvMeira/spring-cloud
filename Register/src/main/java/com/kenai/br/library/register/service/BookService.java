package com.kenai.br.library.register.service;

import com.kenai.br.library.register.model.Book;
import com.kenai.br.library.register.model.dto.BookDTO;
import com.kenai.br.library.register.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService extends AbstractService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Find a Book by their name
     *
     * @param name
     * @return Optional with a BookDTO
     */

    public Optional<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    /**
     * Basic Save Method for a Book
     *
     * @param bookDTO
     * @return bookDTO that was save
     */
    public BookDTO save(BookDTO bookDTO) {
        return this.map(this.bookRepository
                .save(this.map(bookDTO, Book.class)), BookDTO.class);
    }

    /**
     * Basic ListAll Method for Book
     *
     * @return
     */
    public List<BookDTO> findAll() {
        List<Book> target = new ArrayList<>();
        this.bookRepository.findAll().forEach(target::add);
        return this.map(target, BookDTO.class);
    }

    /**
     * Basic Find by id  for a book
     * @param id
     * @return
     */
    public BookDTO findOne(Long id) {
        Book book = this.bookRepository.findOne(id);
        return (null != book ? this.map(book, BookDTO.class) : null);
    }

    /**
     * Basic Update by a ID and a bookDTO that will be saved
     * @param id
     * @param bookDTO
     * @return
     */
    public BookDTO update(Long id, BookDTO bookDTO) {
        BookDTO toUpdate = this.findOne(id);
        if (null != toUpdate) {
            return this.map(this.bookRepository.save(this.map(toUpdate, Book.class)),BookDTO.class);
        }
        this.logger.debug("No book found for the given ID ");
        throw new RuntimeException("No Book found for the given ID");
    }

    /**
     * Basic cont method for how many book exist
     * @return
     */
    public Long count(){
        return this.bookRepository.count();
    }

    /**
     * Basic method to delete all books on the database
     */
    public void deleteAll(){
        this.bookRepository.deleteAll();
    }

    /**
     * Basic method to delete a specific book
     * @param id
     */
    public void delete(Long id) {
        this.bookRepository.delete(id);
    }

}
