package com.example.fitTrace.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    
    private String accountType; // E.g., Checking, Savings
    private Double balance;
    private LocalDateTime createdDate;
    private String status; // Active, Suspended, Closed
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonManagedReference
    //When you have a field with @JsonIgnore in your entity, it will be ignored in JSON responses and requests, which means it won’t appear in the JSON you send or receive in Postman.
    private User user;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    
    private List<Transaction> transactions;

	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Account(Long accountId, User user, String accountType, Double balance, LocalDateTime createdDate,
			String status) {
		super();
		this.accountId = accountId;
		this.user = user;
		this.accountType = accountType;
		this.balance = balance;
		this.createdDate = createdDate;
		this.status = status;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Methods to deposit, withdraw, transfer, etc.
    
}
