package com.rest.bootrestbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.bootrestbook.entities.Book;
import com.rest.bootrestbook.services.BookService;

@RestController
public class BoockController {

    @Autowired
    private BookService bookService;

    // get all book handler
    // @GetMapping("/books")
    // public List<Book> getBooks() {
    // return this.bookService.getAllBooks();
    // }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> list = this.bookService.getAllBooks();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(list);
    }

    // get specific id details
    // @GetMapping("/books/{id}")
    // public Book getBookBYId(@PathVariable("id") int id) {
    // return this.bookService.getBookBYId(id);
    // }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookBYId(@PathVariable("id") int id) {
        Book b = this.bookService.getBookBYId(id);
        if (b == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

        return ResponseEntity.of(Optional.of(b));
    }

    // create a book in the list
    // @PostMapping("/books")
    // public Book addBook(@RequestBody Book book) {
    // Book b = this.bookService.addBook(book);
    // return b;
    // }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book b = null;
        try {
            b = this.bookService.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(b);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // delete a book handler
    // @DeleteMapping("/books/{id}")
    // public void deleteBook(@PathVariable("id") int id) {
    // this.bookService.deleteBook(id);
    // }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
        try {
            this.bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    // update book handler
    // @PutMapping("books/{id}")
    // public Book updateBook(@RequestBody Book book, @PathVariable("id") int id) {
    // this.bookService.updateBook(book, id);
    // return book;
    // }

    @PutMapping("books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") int id) {
        try {
            this.bookService.updateBook(book, id);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
