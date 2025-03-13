package com.example.fitTrace.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.fitTrace.entity.Account;
import com.example.fitTrace.entity.AccountRequest;
import com.example.fitTrace.entity.User;

public interface AccountService {
	public Account createAccount(AccountRequest accountRequest);
    public Account deposit(Long AccId, Double amount);
    public Account withdraw(Long AccId, Double amount) ;
    public String transferFunds(Long fromId, Long toId, Double amount) ;
    //public List<Page<Account>> ListAllAccounts(int page , int size);
    public Double SecondhighestBalance();
}
