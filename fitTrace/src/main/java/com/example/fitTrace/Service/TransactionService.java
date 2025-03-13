package com.example.fitTrace.Service;
import java.util.*;

import org.springframework.data.domain.Page;

import com.example.fitTrace.entity.Transaction;
public interface TransactionService {
	
 public List<Transaction> getAllServices();
 public List<Transaction> getByAccId(Long accId);
 public List<Transaction> getByTransactionType(String type);
 public Transaction getTransactionById(Long id);
}
