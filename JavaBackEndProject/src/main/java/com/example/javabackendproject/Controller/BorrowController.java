package com.example.javabackendproject.Controller;
import com.example.javabackendproject.Services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;
    // PUT /api/return/{bookId}/patron/{patronId}
    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<String> returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        boolean success = borrowService.returnBook(bookId, patronId);
        if (success) {
            return new ResponseEntity<>("Book returned successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to return the book.", HttpStatus.BAD_REQUEST);
        }
    }
}