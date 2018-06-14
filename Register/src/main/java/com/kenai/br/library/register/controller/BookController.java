package com.kenai.br.library.register.controller;

import com.kenai.br.library.register.model.dto.BookDTO;
import com.kenai.br.library.register.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/register/book/")
@Api(value = "Book", description = "Book Controller", tags = "book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ApiOperation(value = "Find all books ")
    @GetMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public ResponseEntity<List<BookDTO>> getAll(){
        return ResponseEntity.ok(bookService.findAll());
    }

    @ApiParam(value = "Save a Book")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public BookDTO save(@ApiParam(name = "Book", value = "Book to be save", required = true)
                        @RequestBody
                        @Validated BookDTO bookDTO) {
        return this.bookService.save(bookDTO);
    }
}
