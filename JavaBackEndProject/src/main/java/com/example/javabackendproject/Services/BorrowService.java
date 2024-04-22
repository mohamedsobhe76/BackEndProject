package com.example.javabackendproject.Services;
import com.example.javabackendproject.model.entities.Book;
import com.example.javabackendproject.model.entities.BorrowingRecord;
import com.example.javabackendproject.model.entities.Patron;
import com.example.javabackendproject.reposatories.BookRepository;
import com.example.javabackendproject.reposatories.BorrowingRecordRepository;
import com.example.javabackendproject.reposatories.PatornRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowService {

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PatornRepository patronRepository;



    public boolean returnBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Patron patron = (Patron) patronRepository.findById(patronId).orElse(null);

        if (book != null && patron != null) {
            BorrowingRecord borrowingRecord = borrowingRecordRepository.findByBookIdAndPatronIdAndStatus(bookId, patronId);
            if (borrowingRecord != null) {
                borrowingRecordRepository.save(borrowingRecord);
                bookRepository.save(book);

                return true;
            }
        }
        return false;
    }
}