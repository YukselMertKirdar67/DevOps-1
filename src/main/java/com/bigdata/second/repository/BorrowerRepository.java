package com.bigdata.second.repository;

import com.bigdata.second.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
    boolean existsByMemberIdAndReturnDateIsNull(Long memberId);

    boolean existsByBookIdAndReturnDateIsNull(Long bookId);

}
