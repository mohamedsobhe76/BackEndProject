package com.example.patorntest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface patornREP extends JpaRepository<Patron,Long> {
}
