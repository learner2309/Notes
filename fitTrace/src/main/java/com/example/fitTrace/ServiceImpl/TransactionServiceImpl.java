package com.example.fitTrace.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.fitTrace.Service.TransactionService;
import com.example.fitTrace.entity.Transaction;
import com.example.fitTrace.exception.UserNotFoundException;
import com.example.fitTrace.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionRepository repo;

	@Override
	public List<Transaction> getAllServices() {
		// TODO Auto-generated method stub
		//Pageable pg = pageRequest.Of(page,size);
		//Pageable p = PageRequest.of(page, size);  //
		return repo.findAll();
	}

	@Override
	public List<Transaction> getByAccId(Long accId) {
		// TODO Auto-generated method stub
	    
		List<Transaction> tran = repo.findAll().stream().filter(i->i.getAccount().getAccountId()==accId).toList();
		return tran;
	}

	@Override
	public List<Transaction> getByTransactionType(String type) {
		// TODO Auto-generated method stub
	
		List<Transaction> getAllTransactionByType= 	repo.findAll().stream().filter(i->i.getTransactionType().equals(type)).toList();
		return getAllTransactionByType;
	}

	@Override
	public Transaction getTransactionById(Long id) {
		// TODO Auto-generated method stub
		if(repo.existsById(id))
		{
		Transaction t  = repo.getById(id);
		return t;
		}
		else
		{
			throw new UserNotFoundException("not found");
		}
		//t.getAccount();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
