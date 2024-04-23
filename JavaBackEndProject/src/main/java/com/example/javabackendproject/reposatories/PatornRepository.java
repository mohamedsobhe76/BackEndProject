package com.example.javabackendproject.reposatories;

import com.example.javabackendproject.model.entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PatornRepository extends JpaRepository<Patron,Long> {
}
