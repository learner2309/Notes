package com.example.fitTrace.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
   
    private String transactionType; // Deposit, Withdrawal, Transfer
    private Double amount;
    private LocalDateTime transactionDate;
    private String description;
    @ManyToOne
    
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Transaction(Long transactionId, Account account, String transactionType, Double amount,
			LocalDateTime transactionDate, String description) {
		super();
		this.transactionId = transactionId;
		this.account = account;
		this.transactionType = transactionType;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.description = description;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Constructors, Getters, and Setters
    
}
