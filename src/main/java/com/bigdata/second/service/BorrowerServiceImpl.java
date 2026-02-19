package com.bigdata.second.service;

import com.bigdata.second.entity.Book;
import com.bigdata.second.entity.Borrower;
import com.bigdata.second.entity.Member;
import com.bigdata.second.exception.ResourceNotFoundException;
import com.bigdata.second.exception.ValidationException;
import com.bigdata.second.repository.BookRepository;
import com.bigdata.second.repository.BorrowerRepository;
import com.bigdata.second.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowerServiceImpl implements BorrowerService {

    private final BorrowerRepository borrowerRepo;
    private final MemberRepository memberRepo;
    private final BookRepository bookRepo;

    public BorrowerServiceImpl(BorrowerRepository borrowerRepo,
                               MemberRepository memberRepo,
                               BookRepository bookRepo) {
        this.borrowerRepo = borrowerRepo;
        this.memberRepo = memberRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public Borrower borrowBook(Long memberId, Long bookId,
                               LocalDate issueDate, LocalDate dueDate) {
        Member member = memberRepo.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member", memberId));

        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", bookId));

        // Due date, issue date'den sonra olmalı
        if (!dueDate.isAfter(issueDate)) {
            throw new ValidationException("Due date must be after issue date");
        }

        // Issue date geleceğe ait olmamalı
        if (issueDate.isAfter(LocalDate.now())) {
            throw new ValidationException("Issue date cannot be in the future");
        }

        Borrower borrower = new Borrower();
        borrower.setMember(member);
        borrower.setBook(book);
        borrower.setIssueDate(issueDate);
        borrower.setDueDate(dueDate);

        return borrowerRepo.save(borrower);
    }

    @Override
    public List<Borrower> getAllBorrowers() {
        return borrowerRepo.findAll();
    }

    @Override
    public Borrower returnBook(Long borrowerId) {
        Borrower borrower = borrowerRepo.findById(borrowerId)
                .orElseThrow(() -> new ResourceNotFoundException("Borrower", borrowerId));

        if (borrower.getReturnDate() != null) {
            throw new ValidationException("This book has already been returned on: " + borrower.getReturnDate());
        }

        borrower.setReturnDate(LocalDate.now());
        return borrowerRepo.save(borrower);
    }
}