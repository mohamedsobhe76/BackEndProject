package com.example.javabackendproject.Services.ServiceRepos;

public interface BorrowOpRepo {
    boolean returnBook(Long bookId, Long patronId);
}
