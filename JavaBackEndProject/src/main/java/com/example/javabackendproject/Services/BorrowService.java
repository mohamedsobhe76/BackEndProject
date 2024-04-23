package com.example.javabackendproject.Services;
import com.example.javabackendproject.Services.ServiceRepos.BorrowOpRepo;
import com.example.javabackendproject.model.entities.Book;
import com.example.javabackendproject.model.entities.BorrowingRecord;
import com.example.javabackendproject.model.entities.Patron;
import com.example.javabackendproject.reposatories.BookRepository;
import com.example.javabackendproject.reposatories.BorrowingRecordRepository;
import com.example.javabackendproject.reposatories.PatornRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BorrowService implements BorrowOpRepo {

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PatornRepository patronRepository;



    public boolean returnBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Patron patron =  patronRepository.findById(patronId).orElse(null);

        if (book != null && patron != null) {
            BorrowingRecord borrowingRecord=null;
            BorrowingRecord newborrowingRecord = borrowingRecordRepository.findByBookIdAndPatronIdAndStatus(bookId, patronId);
            if (newborrowingRecord != null) {
                borrowingRecordRepository.save(newborrowingRecord);
                bookRepository.save(book);

                return true;
            }
        }
        return false;
    }
}