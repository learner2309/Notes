package com.example.fitTrace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fitTrace.ServiceImpl.AccountServiceImpl;
import com.example.fitTrace.entity.Account;
import com.example.fitTrace.entity.AccountRequest;
import com.example.fitTrace.entity.User;

@RestController
public class AccountController {
	
	@Autowired
	AccountServiceImpl accountservice;
	@PostMapping("/user/account")
	public Account createAccount(@RequestBody AccountRequest account) {
	//	System.out.print(account.getInitialBalance());
		return accountservice.createAccount(account);
	}
	@PostMapping("/user/deposit/{accId}")
	public Account deposit(@PathVariable Long accId, @RequestBody Double amount) 
	{
		return accountservice.deposit( accId, amount);
	}
	@PostMapping("/user/withdraw/{accId}")
	public Account withdraw(@PathVariable Long accId,@RequestBody Double amount) 
	{
		return accountservice.withdraw(accId, amount);
	}
	@PostMapping("/user/transfer/{fromId}/{toId}")
	public String transferFunds(@PathVariable Long fromId,@PathVariable Long toId, @RequestBody Double amount) 
	{
		return  accountservice.transferFunds(fromId, toId, amount);
	}
	
	@GetMapping("/get/balance")
	public Double SecondhighestBalance() {
		return accountservice.SecondhighestBalance();
	}
	}

