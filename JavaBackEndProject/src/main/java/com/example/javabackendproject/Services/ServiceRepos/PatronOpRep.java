package com.example.javabackendproject.Services.ServiceRepos;

import com.example.javabackendproject.model.entities.Patron;

import java.util.List;

public interface PatronOpRep {
    List<Patron> getAllPatrons();
    Patron getPatronById(Long id);
    Patron addPatron(Patron patron);
    Patron updatePatron(Long id, Patron patron);
    boolean deletePatron(Long id);
}
