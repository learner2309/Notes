package com.example.fitTrace.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fitTrace.entity.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
   

}
