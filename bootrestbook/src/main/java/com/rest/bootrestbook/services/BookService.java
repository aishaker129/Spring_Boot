package com.rest.bootrestbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.bootrestbook.data.BookRepository;
import com.rest.bootrestbook.entities.Book;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // private static List<Book> list = new ArrayList<>();
    // static {
    //     list.add(new Book(2, "C++", "Mahfuz Mia"));
    //     list.add(new Book(3, "C", "Rafiul Islam"));
    //     list.add(new Book(4, "JS", "Arnab"));
    //     list.add(new Book(5, "Python", "Rifatul Islam"));
    //     list.add(new Book(6, "Java Spring Boot", "Akhlakul Islam"));
    // }

    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    public Book getBookBYId(int id) {
        Book book = null;
        try{
            // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            book = this.bookRepository.findById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }


    public Book addBook(Book book) {
        try {
            Book result = bookRepository.save(book);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Failed to save Book");
        }
    }

    // public void deleteBook(int id) {
    //     list = list.stream().filter(e->{
    //         if(e.getId() != id){
    //             return true;
    //         } else {
    //             return false;
    //         }
    //     }).collect(Collectors.toList());
    // }

    public void deleteBook(int id) {
        // list = list.stream().filter(e -> e.getId() != id).collect(Collectors.toList());
        bookRepository.deleteById(id);
    }
    
    // update the book

    public void updateBook(Book book, int id) {
        // list = list.stream().map(b->{
        //     if(b.getId()==id){
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }

        //     return b;
        // }).collect(Collectors.toList());
        book.setId(id);
        bookRepository.save(book);
    }
}
