package com.example.javabackendproject.Services;

import com.example.javabackendproject.model.entities.Patron;
import com.example.javabackendproject.reposatories.PatornRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronService {
    @Autowired
    private PatornRepository patronRepository;

    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    public Patron getPatronById(Long id) {
        return (Patron) patronRepository.findById(id).orElse(null);
    }

    public Patron addPatron(Patron patron) {
        return (Patron) patronRepository.save(patron);
    }

    public Patron updatePatron(Long id, Patron patron) {
        if (patronRepository.existsById(id)) {
            patron.setId(id);
            return (Patron) patronRepository.save(patron);
        } else {
            return null;
        }
    }

    public boolean deletePatron(Long id) {
        if (patronRepository.existsById(id)) {
            patronRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
