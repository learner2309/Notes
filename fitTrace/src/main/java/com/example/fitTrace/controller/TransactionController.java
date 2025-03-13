package com.example.fitTrace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fitTrace.ServiceImpl.TransactionServiceImpl;
import com.example.fitTrace.entity.Transaction;
@RestController
public class TransactionController {
	@Autowired
	TransactionServiceImpl tranService;
	@GetMapping("/user/getAllTransactions")
	public List<Transaction> getAllServices() {
		return tranService.getAllServices();
	}
	@GetMapping("/public/getAllByAccId/{accId}")
	public List<Transaction> getByAccId(@PathVariable Long accId) {
	      return tranService.getByAccId(accId);
	}
	@GetMapping("/public/getAllByTransactionType/{type}")
	public List<Transaction> getByTransactionType(@PathVariable String type) {
		System.out.println(type);
		return tranService.getByTransactionType(type);
	}
	@GetMapping("/public/get/transactionByTranId/{id}")
	public Transaction getTransactionById(@PathVariable Long id) {
		return tranService.getTransactionById(id);
	}
}
