package com.example.javabackendproject.reposatories;

import com.example.javabackendproject.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepository extends JpaRepository<Book,Long> {

}
