package com.example.fitTrace.ServiceImpl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
         
import com.example.fitTrace.Service.AccountService;
import com.example.fitTrace.entity.Account;
import com.example.fitTrace.entity.AccountRequest;
import com.example.fitTrace.entity.Transaction;
import com.example.fitTrace.entity.User;
import com.example.fitTrace.exception.AccountNotFoundException;
import com.example.fitTrace.repository.AccountRepository;
import com.example.fitTrace.repository.TransactionRepository;
import com.example.fitTrace.repository.UserRepository;
@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountrepo;
	 @Autowired
	 private UserRepository userRepository;
	@Autowired
	private TransactionRepository tranrepo;
	
	
	@Override
	public Account createAccount(AccountRequest accountRequest) {
		// TODO Auto-generated method stub
		if(accountrepo.existsById(accountRequest.getUserId()))
	    {
	     User user = userRepository.getById(accountRequest.getUserId());
	     Account account = new Account();
	     account.setAccountType(accountRequest.getAccountType());
	     account.setCreatedDate(LocalDateTime.now());
	     account.setBalance(accountRequest.getInitialBalance());
	     account.setStatus("Active");
	     account.setUser(user);
	     return accountrepo.save(account);
				}
		throw new AccountNotFoundException("user details not found with this Id, "+accountRequest.getUserId()+ " enter user id correctly");
	     
	}

	@Override
	public Account deposit(Long accId, Double amount) {
		if(accountrepo.existsById(accId))
		{
		Account account = accountrepo.getById(accId);
		account.setBalance(account.getBalance()+amount);
		Transaction transaction=new Transaction();
		transaction.setAmount(amount);
		transaction.setAccount(account);
		transaction.setDescription("adding");
		transaction.setTransactionType("deposit");
		transaction.setTransactionDate(LocalDateTime.now());
		tranrepo.save(transaction);
		return accountrepo.save(account);
		}
		throw new AccountNotFoundException("account id is not exists");
	}

	@Override
	public Account withdraw(Long accId, Double amount) {
		if(accountrepo.existsById(accId))
		{
		Account account = accountrepo.getById(accId);
		if(amount<=account.getBalance())
		{
		account.setBalance(account.getBalance()-amount);
		 Transaction transaction=new Transaction();
		transaction.setAccount(account);
		transaction.setAmount(amount);
		transaction.setDescription("debited");
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setTransactionType("withdraw");
		tranrepo.save(transaction);
		return accountrepo.save(account);
		}
		    throw new AccountNotFoundException("insufficient balance");
		}
		throw new AccountNotFoundException("account id is not exists");
	}

	@Override
	public String transferFunds(Long fromId,Long toId,Double amount) {
		if(accountrepo.existsById(fromId))
		{
		Account fromAccount = accountrepo.getById(fromId);
		if(accountrepo.existsById(toId))
		{
		Account toAccount = accountrepo.getById(toId);
		
		if(amount<fromAccount.getBalance())
		{
		fromAccount.setBalance(fromAccount.getBalance()-amount);
		toAccount.setBalance(toAccount.getBalance()+amount);
		accountrepo.save(fromAccount);
		accountrepo.save(toAccount);
		Transaction transaction=new Transaction();
		transaction.setAmount(amount);
		transaction.setAccount(accountrepo.getById(fromId));
		transaction.setDescription("debited");
		transaction.setTransactionType("transfer");
		transaction.setTransactionDate(LocalDateTime.now());
		tranrepo.save(transaction);
		Transaction transaction1=new Transaction();
		transaction1.setAmount(amount);
		transaction1.setAccount(accountrepo.getById(toId));
		transaction1.setDescription("credited");
		transaction1.setTransactionType("transfer");
		transaction1.setTransactionDate(LocalDateTime.now());
		tranrepo.save(transaction1);
		
		return "transferred succesfully";
		}
		      throw new AccountNotFoundException("insufficient balence");
		}
		throw new AccountNotFoundException("sender details not found");
		}
		throw new AccountNotFoundException("user is not exists");
	}

	/*
	 * @Override public List<Page<Account>> ListAllAccounts(int page,int size) { //
	 * TODO Auto-generated method stub return accountrepo.findAll(); }
	 */

	@Override
	public Double SecondhighestBalance() {
		// TODO Auto-generated method stub
		Optional<Account> acc = accountrepo.findAll().stream().
				filter(account -> account.getBalance() != null).
				sorted(Comparator.comparing((Account::getBalance),Comparator.nullsLast(Comparator.naturalOrder())).reversed()).
				skip(1).
				findFirst();
		/* disadvantages of writing java 8 approach compare to jpa query
		 * Memory Consumption:
		 * 
		 * All data must be loaded into memory, which can be inefficient for large
		 * datasets. If accountrepo.findAll() fetches thousands (or millions) of
		 * records, this approach will significantly impact application performance and
		 * memory usage. Slower for Large Datasets:
		 * 
		 * Sorting and filtering large datasets in Java will likely be slower than
		 * delegating the computation to a database. Complexity:
		 * 
		 * The stream chain can become harder to read and maintain compared to a simple
		 * query.
		 */

		List<Double> bal = accountrepo.get();
		return bal.getFirst();
	}

}
