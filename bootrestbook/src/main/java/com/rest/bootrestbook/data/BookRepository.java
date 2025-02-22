package com.rest.bootrestbook.data;

import org.springframework.data.repository.CrudRepository;

import com.rest.bootrestbook.entities.Book;


public interface BookRepository extends CrudRepository<Book, Integer>{
    public Book findById(int id);
}
