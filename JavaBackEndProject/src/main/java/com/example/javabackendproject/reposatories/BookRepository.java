package com.example.javabackendproject.reposatories;

import com.example.javabackendproject.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

}
