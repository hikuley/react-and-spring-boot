package com.settle.go.repository;

import com.settle.go.domain.TransactionEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<TransactionEntity, Long> {

}