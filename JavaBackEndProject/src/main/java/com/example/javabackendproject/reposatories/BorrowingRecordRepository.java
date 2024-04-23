package com.example.javabackendproject.reposatories;

import com.example.javabackendproject.model.entities.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord,Long> {

    BorrowingRecord findByBookIdAndPatronIdAndStatus(Long bookId, Long patronId);
}
