package com.example.javabackendproject.Services.ServiceRepos;

import com.example.javabackendproject.model.entities.Book;

import java.util.List;

public interface BookOpRep {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book addBook(Book book);
    Book updateBook(Long id, Book book);
    boolean deleteBook(Long id);

}
